package com.wang.loginclient.net.bean;

public class ResultUser {

    /**
     * msg : 登录失败请检查账号或者密码
     * code : -1
     * detail : {"id":12,"accountNumber":"123456","password":"1","phone":null,"userType":0,"email":"emil","deleted":null,"version":null,"message":"Android客户端默认传入","createTime":null,"updateTime":null}
     */

    private String msg;
    private int code;
    private DetailBean detail;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DetailBean getDetail() {
        return detail;
    }

    public void setDetail(DetailBean detail) {
        this.detail = detail;
    }

    public static class DetailBean {
        /**
         * id : 12
         * accountNumber : 123456
         * password : 1
         * phone : null
         * userType : 0
         * email : emil
         * deleted : null
         * version : null
         * message : Android客户端默认传入
         * createTime : null
         * updateTime : null
         */

        private Long id;
        private String accountNumber;
        private String password;
        private Object phone;
        private int userType;
        private String email;
        private Object deleted;
        private Object version;
        private String message;
        private Object createTime;
        private Object updateTime;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getDeleted() {
            return deleted;
        }

        public void setDeleted(Object deleted) {
            this.deleted = deleted;
        }

        public Object getVersion() {
            return version;
        }

        public void setVersion(Object version) {
            this.version = version;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        @Override
        public String toString() {
            return "DetailBean{" +
                    "id=" + id +
                    ", accountNumber='" + accountNumber + '\'' +
                    ", password='" + password + '\'' +
                    ", phone=" + phone +
                    ", userType=" + userType +
                    ", email='" + email + '\'' +
                    ", deleted=" + deleted +
                    ", version=" + version +
                    ", message='" + message + '\'' +
                    ", createTime=" + createTime +
                    ", updateTime=" + updateTime +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ResultUser{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", detail=" + detail +
                '}';
    }
}
