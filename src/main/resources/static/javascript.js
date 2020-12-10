function resetBatchID() {
    fetch("http://localhost:8080/setbatchID?batchID=" + 0);
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
window.setInterval(function () {
    getJSON('http://localhost:8080/api/v1/live',
        function (err, data) {

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
            if (err !== null) {
                console.log('Something went wrong: ' + err);
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
                document.getElementById('batch_id').innerHTML = batch_id;
                document.getElementById('mach_speed').innerHTML = mach_speed;
                document.getElementById('amount').innerHTML = amount;
                document.getElementById('produced').innerHTML = produced;
                document.getElementById('accepted_products').innerHTML = accepted_products;
                document.getElementById('defect_products').innerHTML = defect_products;
                document.getElementById('humidity').innerHTML = humidity;
                document.getElementById('temperature').innerHTML = temperature;
                document.getElementById('vibration').innerHTML = vibration;
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

function printPDF() {

    const docDefinition = {
        content: [
            {text: 'Batch Report', fontSize: 20},
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
                    'vibration ' + pdfArray[8],
                ], fontSize: 15
            }
        ]
    }
    pdfMake.createPdf(docDefinition).download();
}

window.setInterval(function () {
    getJSON('http://localhost:8080/api/v1/live',
        function (err, data) {
            let barley;
            let hops;
            let malt;
            let wheat;
            let yeast;
            let mtbar;
            let value;
            if (err !== null) {
                console.log('Something went wrong: ' + err);
            } else {
                value = JSON.parse(data);
                for (var i = 0; i < value.length; i++) {
                    var obj = value[i];
                    barley = obj["barley"];
                    hops = obj["hops"];
                    malt = obj["malt"];
                    wheat = obj["wheat"];
                    yeast = obj["yeast"];
                    mtbar = obj["mtbar"];

                    /*   if () {
                         document.getElementById('barley').style.backgroundColor = "green";
                       document.getElementById('hops').style.backgroundColor = "green";
                       document.getElementById('malt').style.backgroundColor = "green";
                       document.getElementById('wheat').style.backgroundColor = "green";
                       document.getElementById('yeast').style.backgroundColor = "green";
                       document.getElementById('mtbar').style.backgroundColor = "green";
                       }*/
                }
            }
        })
}, 1000);

