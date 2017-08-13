package com.example.myapplication.bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by 刘文艺 on 2017/8/8.
 */
@Table(name = "user")
public class LogBean {
    /**
     * status : true
     * code : 1
     * message : 调用成功
     * data : {"user":{"id":159,"username":null,"auth_key":null,"password_hash":"$2y$13$EY7Xe79Pq7EX94mkZo.X/uqc3FPd7UFIEQxGHf/NEmzFUD0tUXM.e","password_reset_token":null,"email":null,"status":1,"created_at":1502114089,"updated_at":1502114089,"access_token":"pv5WHsR-vKxAV2Ler11-B4nM_2T7d9M7","mobile":"18311036057","password_plain":"1225515453","updated_by":null,"created_by":null,"avatar":"http://data.eleteam.com/uploads/public/user/default.jpg"},"app_cart_cookie_id":"68080f04b544671e1a0d378bbed7b959"}
     * share : {}
     */
    @Column(name = "status")
    private boolean status;
    @Column(name = "code")
    private int code;
    @Column(name = "message")
    private String message;
    @Column(name = "data")
    private DataBean data;
    @Column(name = "share")
    private ShareBean share;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public ShareBean getShare() {
        return share;
    }

    public void setShare(ShareBean share) {
        this.share = share;
    }

    public static class DataBean {
        /**
         * user : {"id":159,"username":null,"auth_key":null,"password_hash":"$2y$13$EY7Xe79Pq7EX94mkZo.X/uqc3FPd7UFIEQxGHf/NEmzFUD0tUXM.e","password_reset_token":null,"email":null,"status":1,"created_at":1502114089,"updated_at":1502114089,"access_token":"pv5WHsR-vKxAV2Ler11-B4nM_2T7d9M7","mobile":"18311036057","password_plain":"1225515453","updated_by":null,"created_by":null,"avatar":"http://data.eleteam.com/uploads/public/user/default.jpg"}
         * app_cart_cookie_id : 68080f04b544671e1a0d378bbed7b959
         */

        private UserBean user;
        @Column(name = "app_cart_cookie_id")
        private String app_cart_cookie_id;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getApp_cart_cookie_id() {
            return app_cart_cookie_id;
        }

        public void setApp_cart_cookie_id(String app_cart_cookie_id) {
            this.app_cart_cookie_id = app_cart_cookie_id;
        }

        public static class UserBean {
            /**
             * id : 159
             * username : null
             * auth_key : null
             * password_hash : $2y$13$EY7Xe79Pq7EX94mkZo.X/uqc3FPd7UFIEQxGHf/NEmzFUD0tUXM.e
             * password_reset_token : null
             * email : null
             * status : 1
             * created_at : 1502114089
             * updated_at : 1502114089
             * access_token : pv5WHsR-vKxAV2Ler11-B4nM_2T7d9M7
             * mobile : 18311036057
             * password_plain : 1225515453
             * updated_by : null
             * created_by : null
             * avatar : http://data.eleteam.com/uploads/public/user/default.jpg
             */
            @Column(name = "id")
            private int id;
            @Column(name = "username")
            private String username;
            @Column(name = "auth_key")
            private String auth_key;
            @Column(name = "password_hash")
            private String password_hash;
            @Column(name = "password_reset_token")
            private String password_reset_token;
            @Column(name = "email")
            private String email;
            @Column(name = "status")
            private int status;
            @Column(name = "created_at")
            private int created_at;
            @Column(name = "updated_at")
            private int updated_at;
            @Column(name = "access_token")
            private String access_token;
            @Column(name = "mobile")
            private String mobile;
            @Column(name = "password_plain")
            private String password_plain;
            @Column(name = "updated_by")
            private String updated_by;
            @Column(name = "created_by")
            private String created_by;
            @Column(name = "avatar")
            private String avatar;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public Object getAuth_key() {
                return auth_key;
            }

            public void setAuth_key(String auth_key) {
                this.auth_key = auth_key;
            }

            public String getPassword_hash() {
                return password_hash;
            }

            public void setPassword_hash(String password_hash) {
                this.password_hash = password_hash;
            }

            public Object getPassword_reset_token() {
                return password_reset_token;
            }

            public void setPassword_reset_token(String password_reset_token) {
                this.password_reset_token = password_reset_token;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public String getAccess_token() {
                return access_token;
            }

            public void setAccess_token(String access_token) {
                this.access_token = access_token;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getPassword_plain() {
                return password_plain;
            }

            public void setPassword_plain(String password_plain) {
                this.password_plain = password_plain;
            }

            public Object getUpdated_by() {
                return updated_by;
            }

            public void setUpdated_by(String updated_by) {
                this.updated_by = updated_by;
            }

            public Object getCreated_by() {
                return created_by;
            }

            public void setCreated_by(String created_by) {
                this.created_by = created_by;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }
    }

    public static class ShareBean {
    }
}
