require(['jquery','template','jqueryUi','datepicker','datepickerZh-CN'],function() {
    console.log("aaaaaaaaaaaaaaa");
    M.define('home',function () {
        console.log("bbbbbbbbbbb");
    })(function () {
        M.home.init();
    })
});
