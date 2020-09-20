<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    prop="id"
                    label="图书编号"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="图书名"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="作者">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteBook(scope.row)"type="text" size="small">删除</el-button>
                </template>
            </el-table-column>

        </el-table>
        <el-pagination
                background
                layout="prev, pager, next"
                :page-size="pageSize"
                :total="total"
                @current-change="page">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        created() {
            const _this = this
            axios.get('http://localhost:8081/book/findAll/0/6').then(function (resp) {
                _this.tableData = resp.data.content
                _this.pageSize = resp.data.size;
                _this.total = resp.data.totalElements;
            })
        },
        //默认
        data() {
            return {
                pageSize:1,
                total:11,
                tableData: [{
                    id: '2016-05-02',
                    name: '王小虎',
                    author: '上海市普陀区金沙江路 1518 弄'
                }, {
                    id: '2016-05-02',
                    name: '王小虎',
                    author: '上海市普陀区金沙江路 1518 弄'
                }, {
                    id: '2016-05-02',
                    name: '王小虎',
                    author: '上海市普陀区金沙江路 1518 弄'
                }, {
                    id: '2016-05-02',
                    name: '王小虎',
                    author: '上海市普陀区金沙江路 1518 弄'
                }]
            }
        },
        methods:{
            deleteBook(row){
                const _this = this
                axios.delete('http://localhost:8081/book/deleteById/'+row.id).then(
                    function (resp) {
                        _this.$alert('《'+row.name+'》删除成功！', '消息', {
                            confirmButtonText: '确定',
                            callback: action => {
                                window.location.reload()
                            }
                        })
                    }
                )
            },
            page(currentPage){
                const _this = this
                axios.get('http://localhost:8081/book/findAll/'+(currentPage-1)+'/6').then(function (resp) {
                    _this.tableData = resp.data.content
                    _this.pageSize = resp.data.size;
                    _this.total = resp.data.totalElements;
                })
            },
            edit(row){
                this.$router.push({
                    path:'/updateBook',
                    query:{
                        id:row.id
                    }
                })
            },
        }
    }
</script>