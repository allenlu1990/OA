<template>
  <div class="app-container">
    <el-form :model="dynamicValidateForm" ref="dynamicValidateForm" label-width="100px" class="demo-dynamic">
      <el-row>
        <el-col :span="6">
          <el-form-item label="考核类型" label-width="85px">
            <el-select v-model="dynamicValidateForm.type" filterable placeholder="请选择" clearable size="small">
              <el-option
                v-for="item in typeOptions"
                :key="item.typeId"
                :label="item.typeName"
                :value="item.typeId"
              ></el-option>
            </el-select>
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="考查月份" label-width="85px">
            <el-date-picker value-format="yyyy-MM-dd HH:mm:ss" v-model="dynamicValidateForm.date" type="month" placeholder="选择月"></el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>
      <el-divider>填写需要考核的人员</el-divider>

    <el-row v-for="(domain, index) in dynamicValidateForm.domains" :key="index"> 
    <el-col :span="6" >
      <el-form-item :label="'责任人'+(index+1)" label-width="85px">
        <el-select v-model="domain.ownerId" filterable placeholder="请选择" clearable size="small">
          <el-option
            v-for="item in userOptions"
            :key="item.userId"
            :label="item.userName"
            :value="item.userId"
          ></el-option>
        </el-select>
      </el-form-item>
      </el-col>
      <el-col :span="12" >
       <el-form-item label="考评结果" prop="result" label-width="85px">
         <el-tooltip class="item" effect="dark" content="考评结果为A+或者B以下需要填写理由说明" placement="bottom-end">
          <el-select v-model="domain.result" filterable placeholder="请选择" clearable size="small">
            <el-option
               v-for="item in resultOptions"
               :key="item.dictLabel"
               :label="item.remark"
               :value="item.dictLabel"
            ></el-option>
          </el-select>
         </el-tooltip>
         <el-button @click.prevent="removeDomain(domain)">删除</el-button>
        </el-form-item>
        
    </el-col>
    <el-col :span="14" >
      <el-form-item v-if="['A+','B-','C+','C','C-','D','D+','D-'].includes(domain.result)" label="考评理由" label-width="85px">
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="domain.reason">
          </el-input>
      </el-form-item>
    </el-col>
    </el-row>
    <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="submitForm('dynamicValidateForm')">提交</el-button>
        <el-button @click="addDomain">新增人员</el-button>
      </el-form-item>
    </el-col>
    </el-form> 
  </div>
</template>

<script>
import { listResult } from "@/api/performance/result";
import { listUser } from "@/api/system/user";
import Editor from "@/components/Editor";
import Child from "@/views/performance/normal/child"
export default {
  components: {
    Editor,Child
  },
  data() {
    return {
      //考评类型
      typeOptions: [
        { typeId: 1, typeName: "采购考核" },
        { typeId: 2, typeName: "考勤考核" },
        { typeId: 3, typeName: "生活考核" }
      ],
      // 绩效结果数据字典
      resultOptions: [],
      userOptions:[],

      dynamicValidateForm: {
        domains: [
          {
            value: "",
            ownerId: "",
            result: "",
            reason: ""
          }
        ],
        type: undefined,
        date: undefined
      }
    };
  },
  created() {
    this.getUsers();
    this.getDicts("perfor_result_type").then(response => {
      this.resultOptions = response.data;
    });
  },
  methods: {
    getUsers() {
      listUser().then(response => {
        this.userOptions = response.rows;
      });
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          alert("submit!");
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    removeDomain(item) {
      var index = this.dynamicValidateForm.domains.indexOf(item);
      if (index !== -1) {
        this.dynamicValidateForm.domains.splice(index, 1);
      }
    },
    addDomain() {
      this.dynamicValidateForm.domains.push({
        value: "",
        ownerId: "",
        result: "",
        reason: ""
      });
    }
  }
};
</script>