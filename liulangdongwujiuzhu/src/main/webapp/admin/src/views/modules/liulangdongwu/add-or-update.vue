<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='yezhu'">
                    <el-form-item class="select" v-if="type!='info'"  label="业主" prop="yezhuId">
                        <el-select v-model="ruleForm.yezhuId" :disabled="ro.yezhuId" filterable placeholder="请选择业主" @change="yezhuChange">
                            <el-option
                                    v-for="(item,index) in yezhuOptions"
                                    v-bind:key="item.id"
                                    :label="item.yezhuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yezhu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="业主姓名" prop="yezhuName">
                        <el-input v-model="yezhuForm.yezhuName"
                                  placeholder="业主姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="业主姓名" prop="yezhuName">
                            <el-input v-model="ruleForm.yezhuName"
                                      placeholder="业主姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yezhu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="业主手机号" prop="yezhuPhone">
                        <el-input v-model="yezhuForm.yezhuPhone"
                                  placeholder="业主手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="业主手机号" prop="yezhuPhone">
                            <el-input v-model="ruleForm.yezhuPhone"
                                      placeholder="业主手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='yezhu' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.yezhuPhoto" label="业主头像" prop="yezhuPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (yezhuForm.yezhuPhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.yezhuPhoto" label="业主头像" prop="yezhuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.yezhuPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="yezhuId" name="yezhuId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="流浪动物名称" prop="liulangdongwuName">
                       <el-input v-model="ruleForm.liulangdongwuName"
                                 placeholder="流浪动物名称" clearable  :readonly="ro.liulangdongwuName"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="流浪动物名称" prop="liulangdongwuName">
                           <el-input v-model="ruleForm.liulangdongwuName"
                                     placeholder="流浪动物名称" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="流浪动物编号" prop="liulangdongwuUuidNumber">
                       <el-input v-model="ruleForm.liulangdongwuUuidNumber"
                                 placeholder="流浪动物编号" clearable  :readonly="ro.liulangdongwuUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="流浪动物编号" prop="liulangdongwuUuidNumber">
                           <el-input v-model="ruleForm.liulangdongwuUuidNumber"
                                     placeholder="流浪动物编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' && !ro.liulangdongwuPhoto" label="动物照片" prop="liulangdongwuPhoto">
                        <file-upload
                            tip="点击上传动物照片"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.liulangdongwuPhoto?ruleForm.liulangdongwuPhoto:''"
                            @change="liulangdongwuPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.liulangdongwuPhoto" label="动物照片" prop="liulangdongwuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.liulangdongwuPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="动物类型" prop="liulangdongwuTypes">
                        <el-select v-model="ruleForm.liulangdongwuTypes" :disabled="ro.liulangdongwuTypes" placeholder="请选择动物类型">
                            <el-option
                                v-for="(item,index) in liulangdongwuTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="动物类型" prop="liulangdongwuValue">
                        <el-input v-model="ruleForm.liulangdongwuValue"
                            placeholder="动物类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="动物品种" prop="liulangdongwuPinzhongTypes">
                        <el-select v-model="ruleForm.liulangdongwuPinzhongTypes" :disabled="ro.liulangdongwuPinzhongTypes" placeholder="请选择动物品种">
                            <el-option
                                v-for="(item,index) in liulangdongwuPinzhongTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="动物品种" prop="liulangdongwuPinzhongValue">
                        <el-input v-model="ruleForm.liulangdongwuPinzhongValue"
                            placeholder="动物品种" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="流浪地点" prop="liulangdongwuDidian">
                       <el-input v-model="ruleForm.liulangdongwuDidian"
                                 placeholder="流浪地点" clearable  :readonly="ro.liulangdongwuDidian"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="流浪地点" prop="liulangdongwuDidian">
                           <el-input v-model="ruleForm.liulangdongwuDidian"
                                     placeholder="流浪地点" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12" v-if="!(sessionTable =='yezhu' && type!='info')">
                   <el-form-item class="input" v-if="type!='info'"  label="动物年龄" prop="liulangdongwuAge">
                       <el-input v-model="ruleForm.liulangdongwuAge"
                                 placeholder="动物年龄" clearable  :readonly="ro.liulangdongwuAge"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="动物年龄" prop="liulangdongwuAge">
                           <el-input v-model="ruleForm.liulangdongwuAge"
                                     placeholder="动物年龄" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12" v-if="!(sessionTable =='yezhu' && type!='info')">
                    <el-form-item class="select" v-if="type!='info'"  label="是否救助" prop="jiuzhuTypes">
                        <el-select v-model="ruleForm.jiuzhuTypes" :disabled="ro.jiuzhuTypes" placeholder="请选择是否救助">
                            <el-option
                                v-for="(item,index) in jiuzhuTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="是否救助" prop="jiuzhuValue">
                        <el-input v-model="ruleForm.jiuzhuValue"
                            placeholder="是否救助" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="!(sessionTable =='yezhu' && type!='info')">
                    <el-form-item class="select" v-if="type!='info'"  label="是否健康" prop="jiankangTypes">
                        <el-select v-model="ruleForm.jiankangTypes" :disabled="ro.jiankangTypes" placeholder="请选择是否健康">
                            <el-option
                                v-for="(item,index) in jiankangTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="是否健康" prop="jiankangValue">
                        <el-input v-model="ruleForm.jiankangValue"
                            placeholder="是否健康" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="!(sessionTable =='yezhu' && type!='info')">
                    <el-form-item class="select" v-if="type!='info'"  label="是否绝育" prop="jueyuTypes">
                        <el-select v-model="ruleForm.jueyuTypes" :disabled="ro.jueyuTypes" placeholder="请选择是否绝育">
                            <el-option
                                v-for="(item,index) in jueyuTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="是否绝育" prop="jueyuValue">
                        <el-input v-model="ruleForm.jueyuValue"
                            placeholder="是否绝育" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="!(sessionTable =='yezhu' && type!='info')">
                    <el-form-item class="select" v-if="type!='info'"  label="是否打疫苗" prop="yimiaoTypes">
                        <el-select v-model="ruleForm.yimiaoTypes" :disabled="ro.yimiaoTypes" placeholder="请选择是否打疫苗">
                            <el-option
                                v-for="(item,index) in yimiaoTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="是否打疫苗" prop="yimiaoValue">
                        <el-input v-model="ruleForm.yimiaoValue"
                            placeholder="是否打疫苗" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="动物详细状况" prop="liulangdongwuContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.liulangdongwuContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.liulangdongwuContent" label="动物详细状况" prop="liulangdongwuContent">
                            <span v-html="ruleForm.liulangdongwuContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="!(sessionTable =='yezhu' && type!='info')">
                    <el-form-item class="select" v-if="type!='info'"  label="是否领养" prop="lingyangTypes">
                        <el-select v-model="ruleForm.lingyangTypes" :disabled="ro.lingyangTypes" placeholder="请选择是否领养">
                            <el-option
                                v-for="(item,index) in lingyangTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="是否领养" prop="lingyangValue">
                        <el-input v-model="ruleForm.lingyangValue"
                            placeholder="是否领养" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                yezhuForm: {},
                ro:{
                    yezhuId: false,
                    liulangdongwuName: false,
                    liulangdongwuUuidNumber: false,
                    liulangdongwuPhoto: false,
                    liulangdongwuTypes: false,
                    liulangdongwuPinzhongTypes: false,
                    liulangdongwuDidian: false,
                    liulangdongwuAge: false,
                    liulangdongwuClicknum: false,
                    jiuzhuTypes: false,
                    jiankangTypes: false,
                    jueyuTypes: false,
                    yimiaoTypes: false,
                    liulangdongwuContent: false,
                    lingyangTypes: false,
                    liulangdongwuDelete: false,
                },
                ruleForm: {
                    yezhuId: '',
                    liulangdongwuName: '',
                    liulangdongwuUuidNumber: new Date().getTime(),
                    liulangdongwuPhoto: '',
                    liulangdongwuTypes: '',
                    liulangdongwuPinzhongTypes: '',
                    liulangdongwuDidian: '',
                    liulangdongwuAge: '',
                    liulangdongwuClicknum: '',
                    jiuzhuTypes: '',
                    jiankangTypes: '',
                    jueyuTypes: '',
                    yimiaoTypes: '',
                    liulangdongwuContent: '',
                    lingyangTypes: '',
                    liulangdongwuDelete: '',
                },
                liulangdongwuTypesOptions : [],
                liulangdongwuPinzhongTypesOptions : [],
                jiuzhuTypesOptions : [],
                jiankangTypesOptions : [],
                jueyuTypesOptions : [],
                yimiaoTypesOptions : [],
                lingyangTypesOptions : [],
                yezhuOptions : [],
                rules: {
                   yezhuId: [
                              { required: true, message: '业主不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   liulangdongwuName: [
                              { required: true, message: '流浪动物名称不能为空', trigger: 'blur' },
                          ],
                   liulangdongwuUuidNumber: [
                              { required: true, message: '流浪动物编号不能为空', trigger: 'blur' },
                          ],
                   liulangdongwuPhoto: [
                              { required: true, message: '动物照片不能为空', trigger: 'blur' },
                          ],
                   liulangdongwuTypes: [
                              { required: true, message: '动物类型不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   liulangdongwuPinzhongTypes: [
                              { required: true, message: '动物品种不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   liulangdongwuDidian: [
                              { required: true, message: '流浪地点不能为空', trigger: 'blur' },
                          ],
                   liulangdongwuAge: [
                              { required: true, message: '动物年龄不能为空', trigger: 'blur' },
                          ],
                   liulangdongwuClicknum: [
                              { required: true, message: '宠物热度不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   jiuzhuTypes: [
                              { required: true, message: '是否救助不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   jiankangTypes: [
                              { required: true, message: '是否健康不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   jueyuTypes: [
                              { required: true, message: '是否绝育不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   yimiaoTypes: [
                              { required: true, message: '是否打疫苗不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   liulangdongwuContent: [
                              { required: true, message: '动物详细状况不能为空', trigger: 'blur' },
                          ],
                   lingyangTypes: [
                              { required: true, message: '是否领养不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   liulangdongwuDelete: [
                              { required: true, message: '逻辑删除不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=liulangdongwu_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.liulangdongwuTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=liulangdongwu_pinzhong_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.liulangdongwuPinzhongTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=jiuzhu_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jiuzhuTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=jiankang_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jiankangTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=jueyu_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jueyuTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=yimiao_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yimiaoTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=lingyang_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.lingyangTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `yezhu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yezhuOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            yezhuChange(id){
                this.$http({
                    url: `yezhu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yezhuForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `liulangdongwu/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.yezhuChange(data.data.yezhuId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`liulangdongwu/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.liulangdongwuCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.liulangdongwuCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            liulangdongwuPhotoUploadChange(fileUrls){
                this.ruleForm.liulangdongwuPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>

