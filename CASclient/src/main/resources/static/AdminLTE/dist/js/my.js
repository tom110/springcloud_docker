var globe = new Globe();
var smallDemName00 = "dem00_54mif";
var smallDemName01 = "dem01_54mif";
var smallDemName02 = "dem02_54mif";
var smallDemName03 = "dem03_54mif";
var demName = "dem";
var docName = "地图文档";
var duanCengName = "断层";
var poName = "剖面完整版";
var zuanName = "钻孔";
var mproName = "重大工程适宜性分区图";
var unspaceName = "地下空间10到30";
var genvName = "地质环境";
var obpName = "矿山修复模型";
// var gdisName="地质灾害";
var gdisName = "地灾点";
var mineralName="矿产资源";
var marineranchingName="海洋牧场";
var groundwaterName="地下水监测";
var geothermalName="地热监测";
var dem00Name = "dem00";
var dem01Name = "dem01";
var dem02Name = "dem02";
var dem03Name = "dem03";
var QueryURL = "gdbp://MapGisLocal/Test1/sfcls/land_models";
var kuai = "gdbp://MapGisLocal/Test1/sfcls/land_models";
var duanceng = "gdbp://MapGisLocal/duanceng/sfcls/duancheng";
var po = "gdbp://MapGisLocal/duanceng/sfcls/pomian_modified";
var zuan = "gdbp://MapGisLocal/duanceng/sfcls/entity_133";
var dem00 = "gdbp://MapGisLocal/sample/ras/dem00_54mif";
var dem01 = "gdbp://MapGisLocal/sample/ras/dem01_54mif";
var dem02 = "gdbp://MapGisLocal/sample/ras/dem02_54mif";
var dem03 = "gdbp://MapGisLocal/sample/ras/dem03_54mif";
// var gdis="gdbp://MapGisLocal/地质灾害/sfcls/地质灾害";
var gdis = "gdbp://MapGisLocal/地质灾害/sfcls/灾害点";
var genv = "gdbp://MapGisLocal/sample/sfcls/地质环境3";
var mpro = "gdbp://MapGisLocal/sample/sfcls/工程建设面";
var unspace = "gdbp://MapGisLocal/sample/sfcls/地下空间10-30M3";

var earthDisaster = "gdbp://MapGisLocal/地质灾害/sfcls/灾害点";
var mineral = "gdbp://MapGisLocal/地质灾害/sfcls/矿产资源";
var marineranching = "gdbp://MapGisLocal/地质灾害/sfcls/海洋牧场";
var groundwater = "gdbp://MapGisLocal/地质灾害/sfcls/地下水监测点";
var geothermal = "gdbp://MapGisLocal/地质灾害/sfcls/地热监测点";

var IP = "192.168.0.6";
var port = "6163";
var modelFlag = "kuai";
var sceneID;
var DEMID,POID,DUANCENGID, MPROID, UNSPACEID, GENVID, OBPID, GDISID,MINERALID,MARINERANCHINGID,GROUNDWATERID,GEOTHERMALID;
var map;
var helpGeometry;
var range3Dstr = "";
var globe = new Globe();
var zkmodelId, mxmodelId, commodelId, labelId1, labelId2, labelId3;
var openflag = false, cutflag = true, floodflag = true, addModelFlag = true, pipeFlag = true, findAttrFlag = true;
var mapId_img = 0;
var mapId_cia = 0;
var floodCount = 0;
var floodInfo = new FLoodAnalyzeInfo();
var flood_content, flood_colorFloodValue, flood_alphaSpinnerValue, flood_expanSpinnerValue, flood_highSpinnerValue;
var boomFlag = true;
var first, second;
var pipeFirst, pipeSecond;
var pnts = "";
var shapeType;
var COUNT, X1, X2, Y1, Y2;
var jsonpnts = {"PntArray": []};
var dotarr = [];
var kuaiShowFlag = false;
var zuanShowFlag = false;
var duanShowFlag = false;
var pouShowFlag = false;
var demShowFlag = true;
var mproShowFlag = false;
var unspaceShowFlag = false;
var genvShowFlag = false;
var obpShowFlag = false;
var gdisShowFlag = false;
var mineralShowFlag=false;
var marineranchingShowFlag=false;
var groundwaterShowFlag=false;
var geothermalShowFlag=false;


//地球载入初始化
function init() {
    // alert(window.innerHeight - 50);
    $("#macher2").css("height", window.innerHeight - 50)

    globe.load();
    mapId_img = globe.addTianditu("img");
    mapId_cia = globe.addTianditu("cia");
    //
    //删除上一个标注
    if (labelId1 != "" || labelId2 != "") {
        globe.removeLabelByName(labelId1);
        globe.removeLabelByName(labelId2);
    }

    var strObj = new Bubble();
    strObj.text = "威海城市综合";       //标注文本
    strObj.x = 122.177;                   //标注点X
    strObj.y = 37.33;                    //标注点Y
    strObj.z = 0;                       //标注点Z
    strObj.fontsize = 20;
    strObj.fontcolor = 0xFFFFFFFF;      //字体颜色
    strObj.bgColor = 0xffCDAD00;        //标注区域的背景颜色
    strObj.opacity = 1.0;               //气泡标注透明度
    strObj.width = 30;                  //气泡标注的宽
    strObj.height = 25;                 //气泡标注的高
    strObj.attribute = this.text;

    //调用addBubble方法添加气泡标注
    labelId1 = globe.addBubble(strObj);

    var strObj1 = new Bubble();
    strObj1.text = "泰安城市综合";       //标注文本
    strObj1.x = 117.182;                   //标注点X
    strObj1.y = 36.323;                   //标注点Y
    strObj1.z = 0;                       //标注点Z
    strObj1.fontcolor = 0xFFFFFFFF;      //字体颜色
    strObj1.fontsize = 20;
    strObj1.bgColor = 0xffCDAD00;        //标注区域的背景颜色
    strObj1.opacity = 1.0;               //气泡标注透明度
    strObj1.width = 30;                  //气泡标注的宽
    strObj1.height = 25;                 //气泡标注的高
    strObj1.attribute = this.text;

    //调用addBubble方法添加气泡标注
    labelId2 = globe.addBubble(strObj1);

    //拾取标注的的监听事件
    globe.addEventListener(EventType.PickLabel, pickModels);

    globe.startPickLabel();

    if (labelId == "") {
        alert("添加标注失败！");
    }

    if (mapId == -1) {
        alert("加载地图失败！");
    }

    alert(globe.getVersionNumber());
    // setTimeout("jump()",8000);

    //globe.goToSurfaceMode();

    // addMap();
}

//地球视图跳转
// function jump() {
//     globe.jumpByPos(117.234124,37.232342,100.00,30,30,30);
// }

function pickModels() {
    addMap();
}


//****************************************************************************矿山治理******start
function addBubble() {
    globe.load();

    var strObjx = new Bubble();
    strObjx.text = "矿山治理点";       //标注文本
    strObjx.x = 416828.66;                   //标注点X
    strObjx.y = 4153054.50;                   //标注点Y
    strObjx.z = 31.58;                       //标注点Z
    strObjx.fontcolor = 0xFFFFFFFF;      //字体颜色
    strObjx.fontsize = 20;
    strObjx.bgColor = 0xffCDAD00;        //标注区域的背景颜色
    strObjx.opacity = 1.0;               //气泡标注透明度
    strObjx.width = 30;                  //气泡标注的宽
    strObjx.height = 25;                 //气泡标注的高
    strObjx.attribute = this.text;

    //调用addBubble方法添加气泡标注
    labelId3 = globe.addBubble(strObjx);
    globe.startPickLabel();
}

function addSmallDem() {
    $("#FloodControl").removeClass("control-none");
    $("#FloodControl").attr("src", "/dem");
    globe.load();

    globe.removeAll();
    // globe.goToGlobeMode();
    sceneID = globe.addDoc(dem00Name, IP, "6163", DocType.TypeG3D);
    globe.reset();
}

function showdem00() {
    globe.load();
    globe.removeAll();
    sceneID = globe.addDoc(dem00Name, IP, "6163", DocType.TypeG3D);
}

function showdem01() {
    globe.load();
    globe.removeAll();
    sceneID = globe.addDoc(dem01Name, IP, "6163", DocType.TypeG3D);
}

function showdem02() {
    globe.load();
    globe.removeAll();
    sceneID = globe.addDoc(dem02Name, IP, "6163", DocType.TypeG3D);
}

function showdem03() {
    globe.load();
    globe.removeAll();
    sceneID = globe.addDoc(dem03Name, IP, "6163", DocType.TypeG3D);
}

function addMonitor() {
    globe.load();
    var labelObj;
    labelObj = new Label();
    labelObj.text = "武汉";       //文本
    labelObj.x = 416828.66;           //标注点X
    labelObj.y = 4153054.50;     //标注点Y
    labelObj.z = 31.58;               //标注点Z
    labelObj.attribute = "123";

    alert("ues");
    //调用addLabel方法添加文本标注
    var tempElement = globe.addLabel(labelObj);
    if (tempElement == "") {
        alert("添加标注失败！");
    }

}


function stopkuang() {
    $("#FloodControl").addClass("control-none");
    globe.load();
    globe.removeAll();
    DEMID = globe.addDoc(demName, IP, port, DocType.TypeG3D);
    globe.reset();
}

//****************************************************************************矿山治理******end

function sparkAllModels(modelFlag) {
    globe.load();
    if (modelFlag == "gdis") {
        $.post("/getModelIds", {
            modelFlag: modelFlag
        }, function (data) {
            for (var i in data) {
                var info = "LayerIndex:14,ObjID:" + i + ",SddHandle:" + GDISID;
                globe.startModelDiplay(info, 1, false);
            }
        })
    }
}

//****************************************************************************加载模型和地层******start

//加载模型
function addMap() {
    globe.load();

    globe.removeEventListener(EventType.PickLabel, pickModels);
    globe.stopPickLabel();

    //删除上一个标注
    if (labelId1 != "" || labelId2 != "") {
        globe.removeLabelByName(labelId1);
        globe.removeLabelByName(labelId2);
        // globe.removeAllLabel();
    }

    globe.removeAll();
    if (DEMID > 0 || DEMID) {
        removeCut();
        globe.removeAllDoc();
    }
    globe.goToSurfaceMode();//进入表面模式
    // globe.setEnvLight(0x99999999);
    globe.setEnvLight(0x99999999);
    sceneID = globe.addDoc(demName, IP, "6163", DocType.TypeG3D);
    globe.reset();//定位到模型所在位置
    //获取被切割图层的Range3D
    range3Dstr = globe.getSceneProperty(sceneID, 0, "Range3D");//只能获取模型图层的空间范围
}

//加载地层控制
function manageKuai() {
    if (!kuaiShowFlag) {
        addMapKuai();
        $("#kuaiShow").removeClass("fa fa-toggle-off");
        $("#kuaiShow").addClass("fa fa-toggle-on");
        kuaiShowFlag = true;
    } else {
        removeMap();
        $("#kuaiShow").removeClass("fa fa-toggle-on");
        $("#kuaiShow").addClass("fa fa-toggle-off");
        kuaiShowFlag = false;
    }
}

//加载地层
function addMapKuai() {
    sceneID = globe.addDoc(docName, IP, port, DocType.TypeG3D);
    if (DEMID < 0) {
        alert("加载失败！");
        return;
    }
    stopPickModelReady();
    stopPickModelReady();
    $("#findAttrIcon").removeClass("fa  fa-toggle-on");
    $("#findAttrIcon").addClass("fa fa-toggle-off");
    findAttrFlag = true;
    QueryURL = kuai;
    modelFlag = "kuai";
}

//移除地层
function removeMap() {
    globe.load();
    if (sceneID > 0 || sceneID) {
        var doc = globe.getDocByName(docName);
        if (!doc)
            return false;
        return globe.removeDocById(doc.id);
    }
    globe.removeEventListener(EventType.LButtonDblClk, DataQuery);
}

//加载地质灾害点
function manageGDis() {
    if (!gdisShowFlag) {
        addGDis();
        $("#gdisShow").removeClass("fa fa-toggle-off");
        $("#gdisShow").addClass("fa fa-toggle-on");
        gdisShowFlag = true;
    } else {
        removeGDis();
        $("#gdisShow").removeClass("fa fa-toggle-on");
        $("#gdisShow").addClass("fa fa-toggle-off");
        gdisShowFlag = false;
    }
}

//加载地质灾害点
function addGDis() {
    GDISID = globe.addDoc(gdisName, IP, port, DocType.TypeG3D);
    if (GDISID < 0) {
        alert("加载失败！");
        return;
    }
    stopPickModelReady();
    $("#gdisShow").removeClass("fa  fa-toggle-on");
    $("#gdisShow").addClass("fa fa-toggle-off");
    findAttrFlag = true;
    QueryURL = gdis;
    modelFlag = "gdis";

    sparkAllModels(modelFlag);

}

//移除地质灾害点
function removeGDis() {
    globe.load();
    if (GDISID > 0 || GDISID) {
        var doc = globe.getDocByName(gdisName);
        if (!doc)
            return false;
        return globe.removeDocById(doc.id);
    }
    globe.removeEventListener(EventType.LButtonDblClk, DataQuery);
}


//加载断层控制
function manageDuan() {
    if (!duanShowFlag) {
        addDuan();
        $("#duanShow").removeClass("fa fa-toggle-off");
        $("#duanShow").addClass("fa fa-toggle-on");
        duanShowFlag = true;
    } else {
        removeDuan();
        $("#duanShow").removeClass("fa fa-toggle-on");
        $("#duanShow").addClass("fa fa-toggle-off");
        duanShowFlag = false;
    }
}

//加载断层
function addDuan() {
    DUANCENGID = globe.addDoc(duanCengName, IP, port, DocType.TypeG3D);
    if (DUANCENGID < 0) {
        alert("加载失败！");
        return;
    }
    QueryURL = duanceng;
    stopPickModelReady();
    modelFlag = "duan";
}

//移除断层
function removeDuan() {
    globe.load();
    if (DUANCENGID > 0 || DUANCENGID) {
        var doc = globe.getDocByName(duanCengName);
        if (!doc)
            return false;
        return globe.removeDocById(doc.id);
    }
    stopPickModelReady();
}

//加载钻孔控制
function manageZuan() {
    if (!zuanShowFlag) {
        addZuan();
        $("#zuanShow").removeClass("fa fa-toggle-off");
        $("#zuanShow").addClass("fa fa-toggle-on");
        zuanShowFlag = true;
    } else {
        removeZuan();
        $("#zuanShow").removeClass("fa fa-toggle-on");
        $("#zuanShow").addClass("fa fa-toggle-off");
        zuanShowFlag = false;
    }
}

//加载钻孔
function addZuan() {
    DUANCENGID = globe.addDoc(zuanName, IP, port, DocType.TypeG3D);
    if (DUANCENGID < 0) {
        alert("加载失败！");
        return;
    }
    QueryURL = duanceng;
    stopPickModelReady();
    modelFlag = "zuan";
}

//移除钻孔
function removeZuan() {
    globe.load();
    if (DUANCENGID > 0 || DUANCENGID) {
        var doc = globe.getDocByName(zuanName);
        if (!doc)
            return false;
        return globe.removeDocById(doc.id);
    }
    stopPickModelReady();
}

//加载剖面控制
function managePou() {
    if (!pouShowFlag) {
        addPo();
        $("#pouShow").removeClass("fa fa-toggle-off");
        $("#pouShow").addClass("fa fa-toggle-on");
        pouShowFlag = true;
    } else {
        removePo();
        $("#pouShow").removeClass("fa fa-toggle-on");
        $("#pouShow").addClass("fa fa-toggle-off");
        pouShowFlag = false;
    }
}

//加载剖面
function addPo() {
    POID = globe.addDoc(poName, IP, port, DocType.TypeG3D);
    if (POID < 0) {
        alert("加载失败！");
        return;
    }
    QueryURL = po;
    stopPickModelReady();
    modelFlag = "po";
}

//移除剖面
function removePo() {
    globe.load();
    if (POID > 0 || POID) {
        var doc = globe.getDocByName(poName);
        if (!doc)
            return false;
        return globe.removeDocById(doc.id);
    }
    stopPickModelReady();
}


//加载dem控制
function manageDEM() {
    if (!demShowFlag) {
        addDEM();
        $("#demShow").removeClass("fa fa-toggle-off");
        $("#demShow").addClass("fa fa-toggle-on");
        demShowFlag = true;
    } else {
        removeDEM();
        $("#demShow").removeClass("fa fa-toggle-on");
        $("#demShow").addClass("fa fa-toggle-off");
        demShowFlag = false;
    }
}

//加载DEM模型
function addDEM() {
    globe.load();
    DEMID = globe.addDoc(demName, IP, port, DocType.TypeG3D);
    if (DEMID < 0) {
        alert("加载失败！");
        return;
    }
}

//移除DEM模型
function removeDEM() {
    globe.load();
    if (sceneID > 0 || sceneID) {
        var doc = globe.getDocByName(demName);
        if (!doc)
            return false;
        return globe.removeDocById(doc.id);
    }
}

//加载重大项目适宜区
function addMPro() {
    globe.load();
    $("#Legend").removeClass("control-none");
    $("#Legend").attr("src", "/legend/mpro");
    MPROID = globe.addDoc(mproName, IP, port, DocType.TypeG3D);
    if (MPROID < 0) {
        alert("加载失败！");
        return;
    }
    findAttrFlag = true;
    QueryURL = mpro;
    modelFlag = "mpro";
}

// 移除重大项目适宜区
function removeMPro() {
    globe.load();
    $("#Legend").addClass("control-none");
    if (MPROID > 0 || MPROID) {
        var doc = globe.getDocByName(mproName);
        if (!doc)
            return false;
        return globe.removeDocById(doc.id);
    }
    globe.removeEventListener(EventType.LButtonDblClk, DataQuery);
}

// 管理重大项目适宜区
function manageMPro() {
    if (!mproShowFlag) {
        addMPro();
        $("#mproShow").removeClass("fa fa-toggle-off");
        $("#mproShow").addClass("fa fa-toggle-on");
        mproShowFlag = true;
    } else {
        removeMPro();
        $("#mproShow").removeClass("fa fa-toggle-on");
        $("#mproShow").addClass("fa fa-toggle-off");
        mproShowFlag = false;
    }
}

//加载地下空间10到30米
function addUnSpace() {
    globe.load();
    $("#Legend").removeClass("control-none");
    $("#Legend").attr("src", "/legend/unspace");
    UNSPACEID = globe.addDoc(unspaceName, IP, port, DocType.TypeG3D);
    if (UNSPACEID < 0) {
        alert("加载失败！");
        return;
    }
    QueryURL = unspace;
    stopPickModelReady();
    modelFlag = "unspace";
}

// 移除地下空间10到30米
function removeUnSpace() {
    globe.load();
    $("#Legend").addClass("control-none");
    if (UNSPACEID > 0 || UNSPACEID) {
        var doc = globe.getDocByName(unspaceName);
        if (!doc)
            return false;
        return globe.removeDocById(doc.id);
    }
}

// 管理地下空间10到30米
function manageUnSpace() {
    if (!unspaceShowFlag) {
        addUnSpace();
        $("#unspaceShow").removeClass("fa fa-toggle-off");
        $("#unspaceShow").addClass("fa fa-toggle-on");
        unspaceShowFlag = true;
    } else {
        removeUnSpace();
        $("#unspaceShow").removeClass("fa fa-toggle-on");
        $("#unspaceShow").addClass("fa fa-toggle-off");
        unspaceShowFlag = false;
    }
}

//加载地质环境
function addGEnv() {
    globe.load();
    $("#Legend").removeClass("control-none");
    $("#Legend").attr("src", "/legend/genv");
    GENVID = globe.addDoc(genvName, IP, port, DocType.TypeG3D);
    if (GENVID < 0) {
        alert("加载失败！");
        return;
    }
    QueryURL = genv;
    stopPickModelReady();
    modelFlag = "genv";
}

// 移除地质环境
function removeGEnv() {
    globe.load();
    $("#Legend").addClass("control-none");
    if (GENVID > 0 || GENVID) {
        var doc = globe.getDocByName(genvName);
        if (!doc)
            return false;
        return globe.removeDocById(doc.id);
    }
}

// 管理地质环境
function manageGEnv() {
    if (!genvShowFlag) {
        addGEnv();
        $("#genvShow").removeClass("fa fa-toggle-off");
        $("#genvShow").addClass("fa fa-toggle-on");
        genvShowFlag = true;
    } else {
        removeGEnv();
        $("#genvShow").removeClass("fa fa-toggle-on");
        $("#genvShow").addClass("fa fa-toggle-off");
        genvShowFlag = false;
    }
}

//加载倾斜摄影模型
function addObp() {
    globe.load();
    OBPID = globe.addDoc(obpName, IP, port, DocType.TypeG3D);
    if (OBPID < 0) {
        alert("加载失败！");
        return;
    }
    globe.reset();
}

// 移除倾斜摄影模型
function removeObp() {
    globe.load();
    if (OBPID > 0 || OBPID) {
        var doc = globe.getDocByName(obpName);
        if (!doc)
            return false;
        // globe.removeAll();
        return globe.removeDocById(doc.id);

    }
}

// 管理倾斜摄影模型
function manageObp() {
    if (!obpShowFlag) {
        addObp();
        $("#obpShow").removeClass("fa fa-toggle-off");
        $("#obpShow").addClass("fa fa-toggle-on");
        obpShowFlag = true;
    } else {
        removeObp();
        $("#obpShow").removeClass("fa fa-toggle-on");
        $("#obpShow").addClass("fa fa-toggle-off");
        obpShowFlag = false;
    }
}


//加载矿产资源
function addMineral() {
    globe.load();
    MINERALID = globe.addDoc(mineralName, IP, port, DocType.TypeG3D);
    if (MINERALID < 0) {
        alert("加载失败！");
        return;
    }
    QueryURL = mineral;
    stopPickModelReady();
    modelFlag = "mineral";
}

// 移除矿产资源
function removeMineral() {
    globe.load();
    $("#Legend").addClass("control-none");
    if (MINERALID > 0 || MINERALID) {
        var doc = globe.getDocByName(mineralName);
        if (!doc)
            return false;
        return globe.removeDocById(doc.id);
    }
}

// 管理矿产资源
function manageMineral() {
    if (!mineralShowFlag) {
        addMineral();
        $("#mineralShow").removeClass("fa fa-toggle-off");
        $("#mineralShow").addClass("fa fa-toggle-on");
        mineralShowFlag = true;
    } else {
        removeMineral();
        $("#mineralShow").removeClass("fa fa-toggle-on");
        $("#mineralShow").addClass("fa fa-toggle-off");
        mineralShowFlag = false;
    }
}



//加载地下水监测点
function addGroundwater() {
    globe.load();
    GROUNDWATERID = globe.addDoc(groundwaterName, IP, port, DocType.TypeG3D);
    if (GROUNDWATERID < 0) {
        alert("加载失败！");
        return;
    }
    QueryURL = groundwater;
    stopPickModelReady();
    modelFlag = "groundwater";
}

// 移除地下水监测点
function removeGroundwater() {
    globe.load();
    $("#Legend").addClass("control-none");
    if (GROUNDWATERID > 0 || GROUNDWATERID) {
        var doc = globe.getDocByName(groundwaterName);
        if (!doc)
            return false;
        return globe.removeDocById(doc.id);
    }
}

// 管理地下水监测点
function manageGroundwater() {
    if (!groundwaterShowFlag) {
        addGroundwater();
        $("#groundwaterShow").removeClass("fa fa-toggle-off");
        $("#groundwaterShow").addClass("fa fa-toggle-on");
        groundwaterShowFlag = true;
    } else {
        removeGroundwater();
        $("#groundwaterShow").removeClass("fa fa-toggle-on");
        $("#groundwaterShow").addClass("fa fa-toggle-off");
        groundwaterShowFlag = false;
    }
}


//加载地热监测点
function addGeothermal() {
    globe.load();
    GEOTHERMALID = globe.addDoc(geothermalName, IP, port, DocType.TypeG3D);
    if (GEOTHERMALID < 0) {
        alert("加载失败！");
        return;
    }
    QueryURL = geothermal;
    stopPickModelReady();
    modelFlag = "geothermal";
}

// 移除地热监测点
function removeGeothermal() {
    globe.load();
    $("#Legend").addClass("control-none");
    if (GEOTHERMALID > 0 || GEOTHERMALID) {
        var doc = globe.getDocByName(geothermalName);
        if (!doc)
            return false;
        return globe.removeDocById(doc.id);
    }
}

// 管理地热监测点
function manageGeothermal() {
    if (!geothermalShowFlag) {
        addGeothermal();
        $("#geothermalShow").removeClass("fa fa-toggle-off");
        $("#geothermalShow").addClass("fa fa-toggle-on");
        geothermalShowFlag = true;
    } else {
        removeGeothermal();
        $("#geothermalShow").removeClass("fa fa-toggle-on");
        $("#geothermalShow").addClass("fa fa-toggle-off");
        geothermalShowFlag = false;
    }
}

//加载海洋牧场
function addMarineranching() {
    globe.load();
    MARINERANCHINGID = globe.addDoc(marineranchingName, IP, port, DocType.TypeG3D);
    if (MARINERANCHINGID < 0) {
        alert("加载失败！");
        return;
    }
    QueryURL = marineranching;
    stopPickModelReady();
    modelFlag = "marineranching";
}

// 移除海洋牧场
function removeMarineranching() {
    globe.load();
    $("#Legend").addClass("control-none");
    if (MARINERANCHINGID > 0 || MARINERANCHINGID) {
        var doc = globe.getDocByName(marineranchingName);
        if (!doc)
            return false;
        return globe.removeDocById(doc.id);
    }
}

// 管理海洋牧场
function manageMarineranching() {
    if (!marineranchingShowFlag) {
        addMarineranching();
        $("#marineranchingShow").removeClass("fa fa-toggle-off");
        $("#marineranchingShow").addClass("fa fa-toggle-on");
        marineranchingShowFlag = true;
    } else {
        removeMarineranching();
        $("#marineranchingShow").removeClass("fa fa-toggle-on");
        $("#marineranchingShow").addClass("fa fa-toggle-off");
        marineranchingShowFlag = false;
    }
}



//***********************************************************************加载模型和地层******end


//******************************************************************切割面切割********start
function showABSurface() {
    $("#FloodControl").removeClass("control-none");
    $("#FloodControl").attr("src", "/cutting");
}

//任意平面切割
function ABSurface(alphaValue, beltaValue) {
    //移除切割面
    removeCut();
    //三维切割辅助面
    helpGeometry = globe.createABSurface(range3Dstr, alphaValue, beltaValue);
    // alert(helpGeometry);
}

function showFirst() {
    globe.load();

    if (zkmodelId > 0 || mxmodelId > 0) {
        globe.removeMap(zkmodelId);
        globe.removeMap(mxmodelId);
    }

    if (sceneID > 0 || DEMID) {
        removeCut();
        globe.removeAllDoc();
    }
    alert(first)
    commodelId = globe.appendGeomByUrl("gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/地质模型_" + first, 0, IP, port);
    QueryURL = "gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/地质模型_" + first;
    globe.reset();
}

function showSecond() {
    globe.load();

    if (zkmodelId > 0 || mxmodelId > 0) {
        globe.removeMap(zkmodelId);
        globe.removeMap(mxmodelId);
    }

    if (sceneID > 0 || DEMID) {
        removeCut();
        globe.removeAllDoc();
    }
    alert(second);
    commodelId = globe.appendGeomByUrl("gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/地质模型_" + second, 0, IP, port);
    QueryURL = "gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/地质模型_" + second;
    globe.reset();

}

//执行任意面切割切割
function ABSurfaceexeCut(alphaValue, beltaValue) {
    var orgSFClsStr = QueryURL;
    first = getUuid();
    var leftSFClsStr = "gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/地质模型_" + first;
    second = getUuid();
    var rightSFClsStr = "gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/地质模型_" + second;

    // var alphaValue = 0;
    // var beltaValue = 45;
    var scaleValue = "2:2:2";
    globe.exeCutByABSurface(orgSFClsStr, leftSFClsStr, rightSFClsStr, alphaValue, beltaValue, scaleValue, function () {
        alert("切割成功")
    }, errorCallback, IP, 6163);
}

//移除切割面
function removeCut() {
    if (helpGeometry) {
        globe.remove(helpGeometry);
    }
}

function stopCuttingAnaysis() {
    removeCut();
    $("#FloodControl").addClass("control-none");

    globe.removeEventListener(EventType.LButtonDblClk, AddPipePnt);
    globe.removeEventListener(EventType.RButtonDown, createpipe);
}

//***********************************************************************切割面切割********end

//*******************************************************************隧道钻孔切割**********start
function showPipeSurface() {
    $("#FloodControl").removeClass("control-none");
    $("#FloodControl").attr("src", "/pipe");

    globe.addEventListener(EventType.LButtonDblClk, AddPipePnt);
    // globe.addEventListener(EventType.RButtonDown, createpipe);

    removeCut();
    dotarr = [];
}

//双击添加点
function AddPipePnt(flag, x, y, dx, dy, dz) {
    if (pipeFlag) {
        var obj1 = new Object();
        obj1.x = dx;
        obj1.y = dy;
        obj1.z = dz;
        alert("添加一点")
        dotarr.push(obj1);
        pipeFlag = false;
        setTimeout(function () {
            pipeFlag = true;
        }, 200);
    }

}

function createpipe() {
    if (pipeFlag) {
        removeCut();
        globe.removeEventListener(EventType.LButtonDblClk, AddPipePnt);
        jsonpnts.pntarray = dotarr;
        pnts = JSON.stringify(jsonpnts);
        var radius = 498.8;//半径
        var secNum = 36;//顶分段数
        var depth = 0;//深度
        var length = 20; // 类型为拱形时有效，表示多边形的长
        var height = 5; //类型为拱形时有效，表示多边形的高
        //三维切割辅助面
        var xmin = $.parseJSON(range3Dstr).range3d.xmin;
        var ymin = $.parseJSON(range3Dstr).range3d.ymin;
        var zmin = $.parseJSON(range3Dstr).range3d.zmin;
        var xmax = $.parseJSON(range3Dstr).range3d.xmax;
        var ymax = $.parseJSON(range3Dstr).range3d.ymax;
        var zmax = $.parseJSON(range3Dstr).range3d.zmax;

        helpGeometry = globe.createPipe(range3Dstr, 'circle', pnts, radius, secNum, depth, length, height);
        alert("生成pipe");
        pipeFlag = false;
        globe.removeEventListener(EventType.RButtonDown, createpipe);
        setTimeout(function () {
            pipeFlag = true;
        }, 200);
    }
}

function createpipeByDepthHeight(depth1, height1) {
    globe.removeEventListener(EventType.LButtonDblClk, AddPipePnt);
    globe.removeEventListener(EventType.RButtonDown, createpipe);
    removeCut();
    globe.removeEventListener(EventType.LButtonDblClk, AddPipePnt);
    jsonpnts.pntarray = dotarr;
    pnts = JSON.stringify(jsonpnts);
    var radius = height1;//半径
    var secNum = 36;//顶分段数
    var depth = depth1;//深度
    var length = 20; // 类型为拱形时有效，表示多边形的长
    var height = 20; //类型为拱形时有效，表示多边形的高
    //三维切割辅助面
    var xmin = $.parseJSON(range3Dstr).range3d.xmin;
    var ymin = $.parseJSON(range3Dstr).range3d.ymin;
    var zmin = $.parseJSON(range3Dstr).range3d.zmin;
    var xmax = $.parseJSON(range3Dstr).range3d.xmax;
    var ymax = $.parseJSON(range3Dstr).range3d.ymax;
    var zmax = $.parseJSON(range3Dstr).range3d.zmax;
    helpGeometry = globe.createPipe(range3Dstr, 'circle', pnts, radius, secNum, depth, length, height);
}

//隧道体切割
function createpipeexeCut(depth1, height1) {
    var orgSFClsStr = QueryURL;
    pipeFirst = getUuid();
    var leftSFClsStr_k = "gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/地质模型_" + pipeFirst;
    pipeSecond = getUuid();
    var rightSFClsStr_k = "gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/地质模型_" + pipeSecond;
    // var pnts = "485710.625,4280000;486705.75,4282905;486678.125,4286303.5;487085.21875,4289067;486678.125,4286303.5;487085.21875,4289067"; //切割路线
    var ps = "";
    var parray = JSON.parse(pnts).pntarray;
    for (var i = 0; i < parray.length; i++) {
        ps = ps + parray[i].x + "," + parray[i].y + ";";
    }
    ps = ps.substring(0, ps.length - 1);
    var type = "circle";
    var radius = height1; //半径
    var number = 36;//顶分段数
    var depth = depth1; //深度
    var length = 20; // 类型为拱形时有效，表示多边形的长
    var height = 5; //类型为拱形时有效，表示多边形的高
    globe.exeCutByPipe(orgSFClsStr, leftSFClsStr_k, rightSFClsStr_k, ps, type, radius, number, depth, length, height, function () {
        alert("切割成功！")
    }, errorCallback, IP, 6163);
}

function showPipeFrist() {
    globe.load();

    if (zkmodelId > 0 || mxmodelId > 0) {
        globe.removeMap(zkmodelId);
        globe.removeMap(mxmodelId);
    }

    if (sceneID > 0 || DEMID) {
        removeCut();
        globe.removeAllDoc();
    }
    alert(pipeFirst)
    commodelId = globe.appendGeomByUrl("gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/地质模型_" + pipeFirst, 0, IP, port);
    QueryURL = "gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/地质模型_" + pipeFirst;
    globe.reset();
}

function showPipeSecond() {
    globe.load();

    if (zkmodelId > 0 || mxmodelId > 0) {
        globe.removeMap(zkmodelId);
        globe.removeMap(mxmodelId);
    }

    if (sceneID > 0 || DEMID) {
        removeCut();
        globe.removeAllDoc();
    }
    alert(pipeSecond)
    commodelId = globe.appendGeomByUrl("gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/地质模型_" + pipeSecond, 0, IP, port);
    QueryURL = "gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/地质模型_" + pipeSecond;
    globe.reset();
}

//**************************************************************************隧道钻孔切割**********end

//*******************************************************************xyz面切割**********start
function showXYZSurface() {
    $("#FloodControl").removeClass("control-none");
    $("#FloodControl").attr("src", "/xyzCutting");

    globe.addEventListener(EventType.LButtonDblClk, AddPipePnt);
    // globe.addEventListener(EventType.RButtonDown, createpipe);

    removeCut();
    dotarr = [];
}

//xyz平面切割
function XYZSurface(z) {
    //移除切割面
    removeCut();
    //三维切割辅助面
    helpGeometry = globe.createXYZSurface(range3Dstr, "z", z);
}

function createXYZCut(z) {
    var orgSFClsStr = QueryURL;
    first = getUuid();
    var leftSFClsStr = "gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/地质模型_" + first;
    second = getUuid();
    var rightSFClsStr = "gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/地质模型_" + second;
    //XYZ平面切割
    var type = "Z";
    var leftValue = z;
    var rigthValue = z;
    globe.exeCutByXYZSurface(orgSFClsStr, leftSFClsStr, rightSFClsStr, type, leftValue, rigthValue,
        function (object) {
            alert("切割成功");
        },
        function (object) {
            alert("切割失败");
        }, ip, port);
}

//**************************************************************************xyz面切割**********end


//*****************************************************************************矩形操作************start
function GetGemoPnt() {
    $("#FloodControl").removeClass("control-none");
    $("#FloodControl").attr("src", "/showModel");
    // alert("kaiqi");
    COUNT = 0;
    globe.removeEventListener(EventType.LButtonDblClk, AddPnt);
    globe.removeEventListener(EventType.RButtonDown, addGraphic);
    globe.addEventListener(EventType.LButtonDblClk, AddPnt);
    globe.addEventListener(EventType.RButtonDown, addGraphic);
}

function removeAllGraphic() {
    $("#FloodControl").addClass("control-none");
    globe.removeEventListener(EventType.LButtonDblClk, AddPnt);
    globe.removeEventListener(EventType.RButtonDown, addGraphic);
    //移除所有几何对象
    globe.removeAllGraphic();
}

function showModel() {
    // alert("hell");
    removeAllGraphic();
    var content = document.frames['FloodControl'].document;
    var n = parseFloat(content.getElementById('n').value);
    var innerLongX = (X2 - X1) / n;
    var innerLongY = (Y2 - Y1) / n;
    var state = globe.setSceneState(DEMID, 4, 5);
    for (var i = 0; i <= n; i++) {
        for (var j = 0; j <= n; j++) {
            createModle(X1 + i * innerLongX, Y1 + j * innerLongY, state);
        }
    }
}

function createModle(x, y, state) {
    // alert(globe.getTerrainEle(x, y));
    var point = x + "," + y + "," + globe.getTerrainEle(x, y);
    var info = new Draw3DElementInfo();
    info.type = Enum3DShapeType.Type3DPoint;
    info.pnts = point;
    info.libID = '1';
    info.symID = '10000019';
    info.fillClr = '0';
    info.transparent = '0';
    info.scale = "20|20|20";
    info.att = 'modelID:1';

    id = globe.draw3DElement(info);
}

function AddPnt(flag, x, y, dx, dy, dz) {

    shapeType = "1";
    if (addModelFlag) {
        if (COUNT == 0) {
            X1 = dx;
            Y1 = dy;
            pnts += dx + "," + dy + ";";
            // alert(pnts);
            addModelFlag = false;
            setTimeout(function () {
                addModelFlag = true;
            }, 300);
            COUNT++;
        } else {
            X2 = dx;
            Y2 = dy;
            pnts += dx + "," + dy + ";";
            // alert(pnts);
            addModelFlag = false;
            setTimeout(function () {
                addModelFlag = true;
            }, 300);
            COUNT = 0;
        }

    }

}

function addGraphic() {
    //绘制参数设置
    var drawInfo = new DrawInfo();
    //设置绘制类型：TypeLine = 0,TypeRect = 1,TypePolygon = 2,TypeCircle = 3,
    drawInfo.shapeType = shapeType;
    //设置背景色
    drawInfo.bdColor = 0xffff0000;
    //设置填充色
    drawInfo.fillColor = 0xff00ffff;
    //设置透明度
    drawInfo.transparence = 1;
    //设置线宽
    drawInfo.linWid = 10;
    //设置线类型 0:实线,1:折线,2:点线,3:折线点
    drawInfo.lineType = 0;

    //绘制几何
    var drawResult = globe.addGraphic(pnts, drawInfo);
    if (drawResult != "") {
        var ele = {id: drawResult, pnts: pnts};
        globe._drawElements.push(ele);
        geomId = ele.id;
    }
    pnts = "";
}

//*******************************************************************************矩形操作************end

//得到uuid
function getUuid() {
    var len = 32;//32长度
    var radix = 16;//16进制
    var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
    var uuid = [], i;
    radix = radix || chars.length;
    if (len) {
        for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random() * radix];
    } else {
        var r;
        uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
        uuid[14] = '4';
        for (i = 0; i < 36; i++) {
            if (!uuid[i]) {
                r = 0 | Math.random() * 16;
                uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
            }
        }
    }
    return uuid.join('');
}


//***********************************************************************************地层爆炸********start
function BoomAnalysis() {
    if (boomFlag) {
        startBoomAnalysis();
        boomFlag = false;
    } else {
        stopBoomAnalysis();
        boomFlag = true;
    }
}

//爆炸显示
function startBoomAnalysis() {
    //实例化一个分析对象
    var info = new BombInfo();
    info.type = 1;
    info.bombtype = 2;      //爆炸方式,0=任意爆炸;1=整体爆炸;2=沿轴向爆炸;
    info.axistype = 3;      //轴向，1=x轴;2=y轴;3=z轴;-1=x轴反向;-2=y轴反向;-3=z轴反向;
    info.expdis = 3000.0; 	//爆炸距离
    info.frame = 30;        //爆炸帧数
    info.radioscale = 0.75; //爆炸范围比例
    info.bomrange = 0; //是否是整个场景爆炸， 1爆炸当前活动图层,0爆炸整个场景
    globe.startAnalyzeTool(info);
}

//结束爆炸显示
function stopBoomAnalysis() {
    globe.setAnalyseType(AnalyseType.Null);
    globe.setAnalyseInfo(null);
    globe.stopAnalyzeTool(EnumCommToolType.BombShow);
}

//***************************************************************************************地层爆炸********end


//显示切割模型结果
function addcutModel() {
    if (sceneID > 0 || DEMID) {
        globe.removeAllDoc();
    }
    commodelId = globe.appendGeomByUrl("gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/b1", 0, IP, port);
    QueryURL = "gdbp://MapGisLocal/IGS_OGC_EPSG_CRS/sfcls/b1";
    globe.reset();
}


//********************************************************************************交互输入填挖方量*******start
function cutfillanalysis1() {
    stopAnalysis();

    $("#FloodControl").removeClass("control-none");
    $("#FloodControl").attr("src", "/cutFill");

}

function fillCut() {
    //获取填挖方分析输入参数
    var content = document.frames['FloodControl'].document;
    var fillColorValue = "0x0fb9ff";
    var cutColorValue = "0x00ff00";
    var noneColorValue = "0x3aeeb3";
    var highTxtValue = content.getElementById('highTxtCut').value;

    //注册事件
    globe.addEventListener(EventType.FinishedAnalyze, getFillCutResult);

    var info = new CutFillInfo();
    //当前进行的分析类别,CutFill为填挖方分析
    info.type = AnalyseType.CutFill;
    //采用用户输入模式
    info.datatype = 0;
    info.bstartreg = 1;
    //当前高程
    info.height = parseInt(highTxtValue, 10);
    //挖的颜色
    info.cutclr = parseInt(cutColorValue, 16);
    //填的颜色
    info.fillclr = parseInt(fillColorValue, 16);
    //不填不挖的颜色
    info.nocutfillClr = parseInt(noneColorValue, 16);
    //设置当前进行的分析类别
    globe.setAnalyseType(AnalyseType.CutFill);
    //开启工具接口
    globe.startAnalyzeTool(info);

}

function getFillCutResult(result) {


    if (cutflag) {
        var jsonObj = eval('(' + result + ')');
        alert("填方量：" + jsonObj.fillvolume + "\r\n" + "挖方量：" + jsonObj.cutvolume + "\r\n" + "分析表面积：" + jsonObj.surfacearea);
        cutflag = false;
        setTimeout(function () {
            cutflag = true;
        }, 2000);
    }

}

//*********************************************************************************交互输入填挖方量*******end


//******************************************************************************交互式分析洪水淹没******start
function flood1() {
    // stopAnalysis();

    $("#FloodControl").removeClass("control-none");
    $("#FloodControl").attr("src", "/flood");
}

function flood() {
    stopAnalysis();
    globe.addEventListener(EventType.LButtonDblClk, startPointCallback);
    alert("请设置观察点");
    //获取淹没分析输入参数
    flood_content = document.frames['FloodControl'].document;
    flood_colorFloodValue = "0xFF1111";
    flood_alphaSpinnerValue = 1;
    flood_expanSpinnerValue = 1;
    flood_highSpinnerValue = flood_content.getElementById("highSpinnerFlood").value;
    floodCount = 0;
}

function startPointCallback(flag, x, y, dx, dy, dz) {
    if (floodflag) {
        if (floodCount == 0) {
            floodInfo.observepos.x = dx;
            floodInfo.observepos.y = dy;
            floodInfo.observepos.z = dz;
            alert("请设置第一个角点");
        } else if (floodCount == 1) {
            floodInfo.startpos.x = dx;
            floodInfo.startpos.y = dy;
            floodInfo.startpos.z = dz;
            alert("请设置第二个角点");
        } else if (floodCount == 2) {
            floodInfo.endpos.x = dx;
            floodInfo.endpos.y = dy;
            floodInfo.endpos.z = dz;
            floodCount = 0;
            globe.removeEventListener(EventType.LButtonDblClk, startPointCallback);
            //注册事件
            // globe.addEventListener(EventType.FinishedAnalyze, getFloodResult);

            //设置当前进行的分析类别为空
            globe.setAnalyseType(AnalyseType.Null);
            //设置当前分析得到的结果为空
            globe.setAnalyseInfo(null);
            //停止工具接口
            globe.stopAnalyzeTool(EnumCommToolType.TerrainAnalyze);
            globe.stopAnalyzeTool(EnumCommToolType.TerrainCut);


            //当前进行的分析类别,FLoodAnalyze为洪水淹没分析
            floodInfo.type = AnalyseType.FLoodAnalyze;
            //透明度(0-1.0之间有效)
            floodInfo.alpha = Number(flood_alphaSpinnerValue);
            //淹没区域颜色
            floodInfo.floodclr = parseInt(flood_colorFloodValue, 16);
            //淹没区域扩大倍数
            floodInfo.regzoom = Number(flood_expanSpinnerValue);
            //数据模式控制，交互拾取和用户输入两种。 0：交互拾取模式； 1: 用户输入模式。
            floodInfo.datatype = 1;
            //当前高程
            floodInfo.height = Number(flood_highSpinnerValue);

            //设置当前进行的分析类别
            globe.setAnalyseType(AnalyseType.FLoodAnalyze);
            //开启工具接口
            globe.startAnalyzeTool(floodInfo);
            // alert("开始分析");
        }
        floodflag = false;
        floodCount++;
        setTimeout(function () {
            floodflag = true;
        }, 500)
    }

}

//***********************************************************************************交互式分析洪水淹没******end

//停止分析功能
function stopAnalysis() {
    //注销双击事件
    globe.removeEventListener(EventType.LButtonDblClk, startPointCallback);
    globe.removeEventListener(EventType.FinishedAnalyze, getFillCutResult);

    globe.removeEventListener(EventType.LButtonDblClk, AddPipePnt);
    globe.removeEventListener(EventType.RButtonDown, createpipe);
    // globe.removeEventListener(EventType.FinishedAnalyze, getFloodResult);
    //设置当前进行的分析类别为空
    globe.setAnalyseType(AnalyseType.Null);
    //设置当前分析得到的结果为空
    globe.setAnalyseInfo(null);
    //停止工具接口
    globe.stopAnalyzeTool(EnumCommToolType.TerrainAnalyze);
    globe.stopAnalyzeTool(EnumCommToolType.TerrainCut);
    $("#FloodControl").addClass("control-none");
}

//双击事件
function secondPnt(flag, x, y, dx, dy, dz) {
    //获取淹没分析输入参数
    var content = document.frames['FloodControl'].document;
    var colorFloodValue = content.getElementById("viewColorFlood").value;
    var alphaSpinnerValue = content.getElementById("alphaSpinnerFlood").value;
    var expanSpinnerValue = content.getElementById("expanSpinnerFlood").value;
    var highSpinnerValue = content.getElementById("highSpinnerFlood").value;

    //设置当前进行的分析类别为空
    globe.setAnalyseType(AnalyseType.Null);
    //设置当前分析得到的结果为空
    globe.setAnalyseInfo(null);
    //停止工具接口
    globe.stopAnalyzeTool(EnumCommToolType.TerrainAnalyze);
    globe.stopAnalyzeTool(EnumCommToolType.TerrainCut);
    //实例化一个分析对象
    var info = new FLoodAnalyzeInfo();
    //当前进行的分析类别,FLoodAnalyze为洪水淹没分析
    info.type = AnalyseType.FLoodAnalyze;
    //透明度(0-1.0之间有效)
    info.alpha = Number(alphaSpinnerValue);
    //淹没区域颜色
    info.floodclr = parseInt(colorFloodValue, 16);
    //淹没区域扩大倍数
    info.regzoom = Number(expanSpinnerValue);
    //数据模式控制，交互拾取和用户输入两种。 0：交互拾取模式； 1: 用户输入模式。
    info.datatype = 1;
    //当前高程
    info.height = Number(highSpinnerValue);
    //观察点
    info.observepos.x = startPoint.x;
    info.observepos.y = startPoint.y;
    info.observepos.z = startPoint.z;

    //起始点x、y、z坐标
    info.startpos.x = firstPntInfo.x;
    info.startpos.y = firstPntInfo.y;
    info.startpos.z = firstPntInfo.z;
    //终止点、y、z坐标
    info.endpos.x = dx;
    info.endpos.y = dy;
    info.endpos.z = dz;
    //设置当前进行的分析类别
    globe.setAnalyseType(AnalyseType.FLoodAnalyze);
    //开启工具接口
    globe.startAnalyzeTool(info);
}

//********************************************************************************************添加3d模型********start
function addPnt() {
    //移除鼠标事件
    globe.removeEventListener(EventType.LButtonDblClk, add3Dpoint);
    //注册鼠标事件
    globe.addEventListener(EventType.LButtonDblClk, add3Dpoint);
}

function add3Dpoint(flag, x, y, dx, dy, dz) {
    var point = dx + "," + dy + "," + dz;
    var info = new Draw3DElementInfo();
    info.type = Enum3DShapeType.Type3DPoint;
    info.pnts = point;
    info.libID = '1';
    info.symID = '10000019';
    info.fillClr = '0';
    info.transparent = '0';
    info.scale = "20|20|20";
    info.att = 'modelID:1';

    id = globe.draw3DElement(info);
    if (id != "") {
        //globe.reset();
    }
}

function removeAll3DElem() {
    //移除所有三维对象
    globe.removeAll3DElement();
}

//************************************************************************************************添加3d模型********end


//*********************************************************************************************开启地层查询********start
function findAttr() {
    if (findAttrFlag) {
        PickModelReady();
        $("#findAttrIcon").removeClass("fa fa-toggle-off");
        $("#findAttrIcon").addClass("fa  fa-toggle-on");
        findAttrFlag = false;
    } else {
        stopPickModelReady();
        $("#findAttrIcon").removeClass("fa  fa-toggle-on");
        $("#findAttrIcon").addClass("fa fa-toggle-off");
        findAttrFlag = true;
    }
}

function PickModelReady() {
    // alert("开启地层查询");
    $("#FloodControl").removeClass("control-none");
    $("#FloodControl").attr("src", "/attrs");
    //移除鼠标事件
    globe.removeEventListener(EventType.LButtonDblClk, DataQuery);
    globe.removeEventListener(EventType.LButtonDblClk, modelQuery);
    //注册鼠标事件
    globe.addEventListener(EventType.LButtonDblClk, DataQuery);
    openflag = true;
}

function DataQuery(flag, x, y, dx, dy, dz) {
    if (openflag) {
        var queryParam = new G3DDocQuery();
        //要素结果集每页的记录数量
        queryParam.pageCount = '1000';
        //被查询图层的gdbpUrl
        queryParam.gdbp = encodeURI(QueryURL);
        if (modelFlag == "mpro" || modelFlag == "genv" || modelFlag == "unspace") {
            queryParam.geometryType = 'Point';//二维查询条件
            queryParam.geometry = dx + "," + dy + "," + ",0.1";//二维查询条件
            alert(dx + "," + dy + "," + ",0.1");
        } else if (modelFlag == "gdis" || modelFlag=="groundwater" || modelFlag=="geothermal" || modelFlag=="marineranching" || modelFlag=="minermal") {
            queryParam.geometryType = 'Point';//二维查询条件
            $.ajax({
                url: '/getNearestPoint',
                type: 'post',
                async: false,//使用同步的方式,true为异步方式
                data: {modelFlag: modelFlag, dx: dx, dy: dy},//这里使用json对象
                success: function (data) {
                    if (data != null) {
                        nearestX = data[0];
                        nearestY = data[1];
                        queryParam.geometry = nearestX.toFixed(2) + "," + nearestY.toFixed(2) + "," + ",0.1";//二维查询条件
                    }
                },
                fail: function () {
                }
            });
        } else {
            //设置查询条件
            queryParam.geometryType = 'Point3D';
            //点的坐标
            queryParam.geometry = dx + "," + dy + "," + dz + ",0.1";
        }
        //指定查询结果的结构
        queryParam.structs = '{"IncludeAttribute":true,"IncludeGeometry":false,"IncludeWebGraphic":false}';
        // igs服务ip
        queryParam.serverIp = IP;
        //igs服务端口
        queryParam.serverPort = port;
        globe.queryG3DFeature(queryParam, queryPolygonsCallback_modle, null, 'post');
        openflag = false;
        setTimeout(function () {
            openflag = true;
        }, 200);
    }
}

function queryPolygonsCallback_modle(data) {
    var content = document.frames['FloodControl'].document;
    content.getElementById("attrs").innerHTML = "";
    if (data.TotalCount > 0) {
        for (var i = 0; i < data.TotalCount; i++) {
            var objid = data.SFEleArray[i].FID;
            // var info = "LayerIndex:0,ObjID:" + objid + ",SddHandle:" + sceneID;
            // globe.startModelDiplay(info, 2, true);
            var att = data.AttStruct.FldName[0];
            var vaule = data.SFEleArray[0].AttValue[0];
            // content.getElementById("attrs").innerHTML+="<li data='"+objid+"' role='presentation'><a href='#'>"+objid+":"+att + "：" + vaule+"</a></li>";
            content.getElementById("attrs").innerHTML += "<li data='" + objid + "' role='presentation'><a href='#'>" + objid + ":" + "名称：" + "模型" + objid + "</a></li>";
            // alert(att + "：" + vaule);
        }
        FloodControl.window.ac();
    }


    // if (data.TotalCount > 0) {
    //     var polygons = new Array();
    //     for (var datalength = 0; datalength < data.TotalCount; datalength++) {
    //         var polygon = { "type": "polygon", "nelen": 1, "ne": [5], "dots": [] };
    //         var dotArray = [];
    //         var obj1 = Object();
    //         obj1.x = data.SFEleArray[datalength].bound.xmin;
    //         obj1.y = data.SFEleArray[datalength].bound.ymin;
    //         dotArray.push(obj1);
    //         var obj2 = Object();
    //         obj2.x = data.SFEleArray[datalength].bound.xmax;
    //         obj2.y = data.SFEleArray[datalength].bound.ymin;
    //         dotArray.push(obj2);
    //         var obj3 = Object();
    //         obj3.x = data.SFEleArray[datalength].bound.xmax;
    //         obj3.y = data.SFEleArray[datalength].bound.ymax;
    //         dotArray.push(obj3);
    //         var obj4 = Object();
    //         obj4.x = data.SFEleArray[datalength].bound.xmin;
    //         obj4.y = data.SFEleArray[datalength].bound.ymax;
    //         dotArray.push(obj4);
    //         var obj5 = Object();
    //         obj5.x = data.SFEleArray[datalength].bound.xmin;
    //         obj5.y = data.SFEleArray[datalength].bound.ymin;
    //         dotArray.push(obj5);
    //         polygon.dots = dotArray;
    //         polygons.push(polygon);
    //     }
    //     // var param = { "maxsencez": range3D.zmax, "transparence": 50, "layerindex": [0], "sddentity": docid.toString(), "reg": polygons };
    //     var param = { "maxsencez": 0, "transparence": 50, "layerindex": [0], "sddentity": GENVID.toString(), "reg": polygons };
    //     var jsoninfo = JSON.stringify(param);
    //     polygonProName = globe.analysis("Add", 3, jsoninfo);
    // }


}

//高亮显示
function sparkModel(objid) {
    globe.load();
    if (QueryURL == kuai) {
        var info = "LayerIndex:0,ObjID:" + objid + ",SddHandle:" + sceneID;
        globe.startModelDiplay(info, 1, true);
    } else if (QueryURL == duanceng) {
        var info = "LayerIndex:23,ObjID:" + objid + ",SddHandle:" + DUANCENGID;
        globe.startModelDiplay(info, 1, true);
    } else if (QueryURL == po) {
        var info = "LayerIndex:3,ObjID:" + objid + ",SddHandle:" + POID;
        globe.startModelDiplay(info, 1, true);
    } else if (QueryURL == gdis) {
        var info = "LayerIndex:14,ObjID:" + objid + ",SddHandle:" + GDISID;
        globe.startModelDiplay(info, 1, true);
    }


    // var info = {"docid": sceneID.toString(),"renderindex": 0,"oid": objid,"visible": 0};
    // globe.setSceneNode(JSON.stringify(info));

    $("#Attr").removeClass("control-none");
    $("#Attr").attr("src", "/attrInfo/" + modelFlag + "/" + objid);
}

//关闭属性查询
function stopPickModelReady() {
    // alert("关闭地层查询");
    $("#FloodControl").addClass("control-none");
    $("#Attr").addClass("control-none");
    globe.removeEventListener(EventType.LButtonDblClk, DataQuery);
    globe.stopModelDisplayAll();
}

//关闭属性查询，但是不停止闪烁
function stopPickModelReadyWithoutDisplay() {
    // alert("关闭地层查询");
    $("#FloodControl").addClass("control-none");
    $("#Attr").addClass("control-none");
    globe.removeEventListener(EventType.LButtonDblClk, DataQuery);
}

//**********************************************************************************************开启地层查询********end


//********************************************************************************************开启模型查询********start

function PickModel() {
    alert("开启全景模型查询");
    //移除鼠标事件
    globe.removeEventListener(EventType.LButtonDblClk, modelQuery);
    globe.removeEventListener(EventType.LButtonDblClk, DataQuery);
    //注册鼠标事件
    globe.addEventListener(EventType.LButtonDblClk, modelQuery);
    openflag = true;
}

function modelQuery(flag, x, y, dx, dy, dz) {
    var queryParam = new G3DDocQuery();
    //要素结果集每页的记录数量
    queryParam.pageCount = '1000';
    //被查询图层的gdbpUrl
    queryParam.gdbp = encodeURI(QueryURL);
    //设置查询条件
    queryParam.geometryType = 'Point3D';
    //点的坐标
    queryParam.geometry = dx + "," + dy + "," + dz + ",0.1";
    //指定查询结果的结构
    queryParam.structs = '{"IncludeAttribute":true,"IncludeGeometry":false,"IncludeWebGraphic":false}';
    // igs服务ip
    queryParam.serverIp = IP;
    //igs服务端口
    queryParam.serverPort = "6163";
    if (globe != null) {
        if (openflag) {
            //三维要素查询
            globe.queryG3DFeature(queryParam, queryPolygonsCallback_M, null, 'post');
            openflag = false;
            setTimeout(function () {
                openflag = true;
            }, 2000);
        }
    }
}

function queryPolygonsCallback_M(data) {
    if (data.TotalCount > 0) {
        window.open("/globleImages");
    }
}

function stopPickModel_M() {
    alert("关闭全景模型查询")
    globe.removeEventListener(EventType.LButtonDblClk, queryPolygonsCallback_M);
    globe.stopModelDisplayAll();
}

//*******************************************************************************************开启模型查询********end

function loadMap() {
    var queryParam = new G3DDocQuery();
    queryParam.pageCount = '1000';
    queryParam.gdbp = encodeURI(URL);
    queryParam.where = '';
    queryParam.serverIp = ip;
    queryParam.serverPort = port;
    queryParam.structs = '{"IncludeAttribute":true,"IncludeGeometry":false,"IncludeWebGraphic":false}';

    if (globe != null) {
        this.globle.queryG3DFeature(queryParam, queryPolygonsCallback, null, 'post');
    }
}

function queryPolygonsCallback(data) {
    for (var i = 0; i < data.TotalCount; i++) {
        modelID = globe.appendGeomByUrl(URL, ip, port, data.SFEleArray[i].FID);
        var model = new Object();
        model.modelID = modelID;
        model.FID = data.SFEleArray[i].FID;
        models.push(model);

        if (modelID > 0) {
            globe.reset();
        } else {
            alert("添加失败");
        }
    }
}

function flash() {
    for (var i = 0; i < models.length; i++) {
        if (models[i].FID == 5) {
            var info = "LayerIndex:0,ObjID:0" + "SddHandle:" + models[i].modelID;
            globe.startModelDiplay(info, EnumModelDispType.Flash, true);
        }
    }
}