function resetBatchID() {
    fetch("http://localhost:8080/setbatchID?batchID=" + 0)
}

function resetMachSpeed() {
    fetch("http://localhost:8080/setmachinespeed?machineSpeed=" + 0);
}

function resetProductAmount() {
    fetch("http://localhost:8080/setproductamount?productAmount=" + 0);
}

function resetProductType() {
    fetch("http://localhost:8080/setproducttype?productType=" + 0);
}

function resetCntrlCmd() {
    fetch("http://localhost:8080/setcntrlcmd?cntrlcmd=" + 1);
}


var pdfArray = [];
pdfArray[0] = 0;
pdfArray[1] = 0;
pdfArray[2] = 0;
pdfArray[3] = 0;
pdfArray[4] = 0;
pdfArray[5] = 0;
pdfArray[6] = 0;
pdfArray[7] = 0;
pdfArray[8] = 0;

var getJSON = function (url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.onload = function () {
        var status = xhr.status;
        if (status === 200) {
            callback(null, xhr.response);
        } else {
            callback(status, xhr.response);
        }
    };
    xhr.send();
};

let count = 0;

let value;
let vibration;
let temperature;
let humidity;
let mach_speed;
let defect_products;
let accepted_products;
var produced;
var amount;
let batch_id;
var timeStamp;

window.setInterval(function () {
    getJSON('http://localhost:8080/api/v1/live',
        function (err, data) {

            if (err !== null) {
                console.log('Something went wrong: ' + err);
            } else if (data === "") {
                return 0;
            } else {
                value = JSON.parse(data);
                for (let i = 0; i < value.length; i++) {
                    let obj = value[i];
                    batch_id = obj["batch_id"];
                    pdfArray.splice(0, 1, batch_id)
                    amount = obj["amount"];
                    pdfArray.splice(1, 1, amount);
                    produced = obj["produced"];
                    pdfArray.splice(2, 1, produced);
                    mach_speed = obj["mach_speed"];
                    pdfArray.splice(3, 1, mach_speed);
                    accepted_products = obj["accepted_products"];
                    pdfArray.splice(4, 1, accepted_products);
                    defect_products = obj["defect_products"];
                    pdfArray.splice(5, 1, defect_products);
                    humidity = obj["humidity"];
                    pdfArray.splice(6, 1, humidity);
                    temperature = obj["temperature"];
                    pdfArray.splice(7, 1, temperature);
                    vibration = obj["vibration"];
                    pdfArray.splice(8, 1, vibration);
                }

                    timeLog();
                    prevSecMethod();
                    var time = new Date;

                    timeStamp = "Time: " + time.getHours().toString() +":"+ time.getMinutes().toString() +":"+ time.getSeconds().toString();

                document.getElementById('batch_id').innerHTML = batch_id;
                document.getElementById('mach_speed').innerHTML = mach_speed;
                document.getElementById('amount').innerHTML = amount;
                document.getElementById('produced').innerHTML = produced;
                document.getElementById('accepted_products').innerHTML = accepted_products;
                document.getElementById('defect_products').innerHTML = defect_products;
                document.getElementById('humidity').innerHTML = humidity;
                document.getElementById('temperature').innerHTML = temperature;
                document.getElementById('vibration').innerHTML = vibration;
                document.getElementById('OEE').innerHTML = accepted_products;
            }



            if (produced == amount && count == 0 && produced != 0)
            {
                    fetch("http://localhost:8080/api/v1/batch",
                        {
                            method: 'POST',
                            headers: {'Content-Type': 'application/json'},
                            body: JSON.stringify({})
                        })
                count += 1;
                }
        });
}, 250);
var bodyPDF = [];
var bodyPDF1 = [];
var bodyPDF2 = [];
var prevSec;
function timeLog() {
        var d = new Date();
        if (d.getSeconds() !== prevSec) {
            var h = d.getHours();
            var m = d.getMinutes();
            var s = d.getSeconds();
            bodyPDF.push({text: h + ":" + m + ":" + s, style: 'tableHeader'});
            bodyPDF1.push({text: temperature.toString(), style: 'tableHeader'});
            bodyPDF2.push({text: humidity.toString(), style: 'tableHeader'});
        }
}
function prevSecMethod() {
    var dp = new Date();
    prevSec = dp.getSeconds();
}
function resetBatchReport() {
    bodyPDF = [];
    bodyPDF1 = [];
    bodyPDF2 = [];
}

window.setInterval(function () {
    getJSON('http://localhost:8080/api/v1/live',
        function (err, data) {
            var barley;
            let hops;
            let malt;
            let wheat;
            let yeast;
            let maintenance;
            let value;
            if (err !== null) {
                console.log('Something went wrong: ' + err);
            } else if (data === "") {
                return 0;
            } else {
                value = JSON.parse(data);
                for (var i = 0; i < value.length; i++) {
                    var obj = value[i];
                    barley = obj["barley"];
                    hops = obj["hops"];
                    malt = obj["malt"];
                    wheat = obj["wheat"];
                    yeast = obj["yeast"];
                    maintenance = obj["maintenance"];

                    barley = Math.round(barley/35000*100)+"%";
                    hops = Math.round(hops/35000*100)+"%";
                    malt = Math.round(malt/35000*100)+"%";
                    wheat = Math.round(wheat/35000*100)+"%";
                    yeast = Math.round(yeast/35000*100)+"%";
                    maintenance = Math.round(maintenance/35000*100)+"%";

                    document.getElementById('barley').innerHTML = barley;
                    document.getElementById('hops').innerHTML = hops;
                    document.getElementById('malt').innerHTML = malt;
                    document.getElementById('wheat').innerHTML = wheat;
                    document.getElementById('yeast').innerHTML = yeast;
                    document.getElementById('mtbar').innerHTML = maintenance;

                }
            }
        })
}, 500);

function printPDF() {

    var docDefinition = {
        content: [
            {
                text: 'Batch Report', fontSize: 20
            },
            {
                ul: [
                    'batch_id ' + pdfArray[0],
                    'amount ' + pdfArray[1],
                    'produced ' + pdfArray[2],
                    'mach_speed ' + pdfArray[3],
                    'accepted_products ' + pdfArray[4],
                    'defect_products ' + pdfArray[5],
                    'humidity ' + pdfArray[6],
                    'temperature ' + pdfArray[7],
                    'vibration ' + pdfArray[8]
                ], fontSize: 15
            },
            {
                text: 'Timelog', fontSize: 20, margin: [ 0, 20, 0, 0 ],
            },
            {
                table: {
                    headerRows: 1,
                    body: [ [ "Time", "Temperature", "Humidity" ],
                        [ bodyPDF, bodyPDF1, bodyPDF2 ],
                    ]
                }
            },
            {
                text: timeStamp,
                fontSize: 25,
                absolutePosition: {x:350, y:20}
            },
        ]
    }
    pdfMake.createPdf(docDefinition).download();
}
