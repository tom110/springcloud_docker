
/*
* ��tooltip�������ʾ��ע����ϸ��Ϣ��iframe
* param {String} left tooltip������ʽ
* param {String} top tooltip�Ķ�����ʽ
* param {String} width tooltip�Ŀ��
* param {String} height tooltip�ĸ߶�
* param {String} info tooltip��iframe��URL��ַ
* param {String} type ��־����
* param {Array} fldName  ��ʾ��Ϣ(ģ�͵���������)
* param {Array} fldValue  ��ʾ��Ϣ(ģ�͵�����ֵ)
*/
function addToolTipDiv(left, top, width, height, info, type, fldName, fldValue) {

    var tooltipDivEle = document.getElementById("toolTipDiv");
    if (tooltipDivEle == undefined) return;

    var tooltipFrameForURLEle = document.getElementById("toolTipFrameForURL");
    if (tooltipFrameForURLEle == undefined) return;

    var obj = document.getElementById("MapGIS_EarthControl");
    var pos = getAbsolutePos(obj);

    tooltipDivEle.style.left = (parseFloat(left) + pos[0]) + "px";
    //tooltipDivEle.style.top = (parseFloat(top) + pos[1]) + "px";
    tooltipDivEle.style.top = (parseFloat(top) + pos[1]) + "px";  
    tooltipDivEle.style.width = width + "px";
    tooltipDivEle.style.height = height + "px";

    if (type == "url") {
        tooltipFrameForURLEle.style.display = "";
        tooltipFrameForURLEle.src = info;
    }
    //��ʾ
    tooltipDivEle.style.display = "";
}
function getAbsolutePos(obj) {
    var ow = [0, 0];
    var pw = obj;
    while (pw && pw.offsetParent) {
        ow[0] += pw.offsetLeft;
        ow[1] += pw.offsetTop;
        pw = pw.offsetParent;
    }
    return ow;
}

