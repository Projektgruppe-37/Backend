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
function resetCCR() {
    fetch("http://localhost:8080/setCCR?valCCR=" + false);
}
function resetCntrlCmd() {
    fetch("http://localhost:8080/setcntrlcmd?cntrlcmd=" + 1);
}
function printPDF() {
    const docDefinition = {
        content: ["batch data"]
    }
    pdfMake.createPdf(docDefinition).download();
}