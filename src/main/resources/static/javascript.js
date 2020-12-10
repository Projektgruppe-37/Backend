window.addEventListener('load', (event) => {
    fetch("http://localhost:8080/setmachinespeed?machineSpeed=" + 0);
});
function queryBatchID(batchID) {
    batchID.addEventListener("input", () => {
        fetch("http://localhost:8080/setbatchID?batchID=" + batchID.value);
    })
}
function queryMachSpeed(machSpeed) {
    machSpeed.addEventListener("input", () => {
        fetch("http://localhost:8080/setmachinespeed?machineSpeed=" + machSpeed.value);
    })
}
function queryProductAmount(productAmount) {
    productAmount.addEventListener("input", () => {
        fetch("http://localhost:8080/setproductamount?productAmount=" + productAmount.value);
    })
}
function queryProductType() {
    productType.addEventListener("input", () => {
        fetch("http://localhost:8080/setproducttype?productType=" + productType.value);
    })
}
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

var getJSON = function(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.onload = function() {
        var status = xhr.status;
        if (status === 200) {
            callback(null, xhr.response);
        } else {
            callback(status, xhr.response);
        }
    };
    xhr.send();
};
window.setInterval(function(){
    getJSON('http://localhost:8080/api/v1/batch',
        function(err, data) {

            let value;
            let vibration;
            let temperature;
            let humidity;
            let defect_products;
            let accepted_products;
            let produced;
            let amount;
            if (err !== null) {
                console.log('Something went wrong: ' + err);
            } else {
                value = JSON.parse(data);
                for (var i = 0; i < value.length; i++) {
                    var productsTotal = 0;
                    var obj = value[i];
                    amount = obj["amount"];
                    pdfArray.splice(0,1,amount);
                    produced = obj["produced"];
                    pdfArray.splice(1,1,produced);
                    accepted_products = obj["accepted_products"];
                    pdfArray.splice(2,1,accepted_products);
                    defect_products = obj["defect_products"];
                    pdfArray.splice(3,1,defect_products);
                    humidity = obj["humidity"];
                    pdfArray.splice(4,1,humidity);
                    temperature = obj["temperature"];
                    pdfArray.splice(5,1,temperature);
                    vibration = obj["vibration"];
                    pdfArray.splice(6,1,vibration);

                    if (productsTotal === amount) {
                        
                    }
                }
                document.getElementById('amount').innerHTML = amount;
                document.getElementById('produced').innerHTML = produced;
                document.getElementById('accepted_products').innerHTML = accepted_products;
                document.getElementById('defect_products').innerHTML = defect_products;
                document.getElementById('humidity').innerHTML = humidity;
                document.getElementById('temperature').innerHTML = temperature;
                document.getElementById('vibration').innerHTML = vibration;
            }

        });
}, 1000);

function printPDF() {

    const docDefinition = {
        content: [
            { text: 'Batch Report', fontSize: 20 },
            { ul: [
                'amount ' + pdfArray[0],
                'produced ' + pdfArray[1],
                'accepted_products ' + pdfArray[2],
                'defect_products ' + pdfArray[3],
                'humidity ' + pdfArray[4],
                'temperature ' + pdfArray[5],
                'vibration ' + pdfArray[6],
                ], fontSize: 15 }
        ]
    }
    pdfMake.createPdf(docDefinition).download();
}

