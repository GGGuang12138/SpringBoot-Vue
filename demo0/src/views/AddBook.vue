<template>
<!--    model 和 rules 分别在data里进行绑定，ref和submitForm进行绑定-->
    <el-form style="width: 60%" :model="form" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="图书名" prop="name">
            <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="作者" prop="author">
            <el-input v-model="form.author"></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>

</template>

<script>
    export default {
        data() {
            return {
                form: {
                    name: '',
                    author: '',
                },
                rules:{
                    name:[
                        {required:true,message:'请输入图书名',trigger:'blur'},
                    ],
                    author:[
                        {required:true,message:'请输入作者',trigger:'blur'},
                    ]
                }
            }
        },
        methods: {
            submitForm(ruleForm) {
                // $refs 是所有注册过的ref的一个集合
                const _this = this
                this.$refs[ruleForm].validate((valid)=>{
                    if (valid){
                        axios.post('http://localhost:8081/book/save',this.form).then(function (resp) {
                            if(resp.data == 'success'){
                                _this.$alert('《'+_this.form.name+'》添加成功！', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/bookManage')
                                    }
                                });
                            }
                        });
                    }else {
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>

</style>