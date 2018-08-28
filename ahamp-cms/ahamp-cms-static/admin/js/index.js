
{
    var app = new Vue({
        el: '#v-index',
        data: {
            category:'',
            title:'',
            articles:[
                // {
                //     title: '测试',
                //     category: '公告',
                //     createTime: '2018-08-23',
                //     publishTime: '2018-08-23 12:00:00'
                // }
            ]
        },
        methods: {
            search: function () {
                this.loadList(1);
            },
            cancelPublish: function (id) {
                $.ajax({
                    type: 'POST',
                    url: '/article/cancelPublish',
                    data: {
                        id:id
                    },
                    success: function (res) {
                        var o = eval('(' + res + ')');
                        if(o.code = 1) {
                            alert("取消成功");
                            window.location.reload();
                        }
                    }
                });
            },
            publish: function (id) {
                $.ajax({
                    type: 'POST',
                    url: '/article/publishById',
                    data: {
                        id:id
                    },
                    success: function (res) {
                        var o = eval('(' + res + ')');
                        if(o.code = 1) {
                            alert("发布成功");
                            window.location.reload();
                        }
                    }
                });
            },
            deleteArticle: function (id) {
                $.ajax({
                    type: 'POST',
                    url: '/article/delete',
                    data: {
                        id:id
                    },
                    success: function (res) {
                        var o = eval('(' + res + ')');
                        if(o.code = 1) {
                            alert("删除成功");
                            window.location.reload();
                        }
                    }
                });
            },
            loadList: function (pageNo) {
                console.log(this.category);
                $.ajax({
                    type: 'POST',
                    url: '/article/article-page',
                    data: {
                        category: this.category,
                        title: this.title,
                        pageNo: pageNo,
                        pageSize: 10
                    },
                    success: function (res) {
                        console.log(res);
                        var page = res;
                        app.articles = page.articleList;
                        kkpager.generPageHtml({
                            pno: page.pageNo,
                            //总页码
                            total: Math.ceil(page.count / page.pageSize),
                            //总数据条数
                            totalRecords: page.count,
                            mode: 'click',
                            click: function (n) {
                                app.loadList(n);
                                this.selectPage(n);
                                return false;
                            }
                        },true);
                    },
                    error:function (res) {
                        console.log(res);
                        alert("拉取失败");
                    }
                });
            }
        },
        // computed: {
        //
        // },
        mounted: function mounted() {
            this.loadList(1);
        }
    });

}