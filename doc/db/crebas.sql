/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/1/2 下午 2:55:52                          */
/*==============================================================*/


drop table if exists t_admin;

drop table if exists t_admin_shop;

drop table if exists t_cart;

drop table if exists t_category;

drop table if exists t_cookie_validate;

drop table if exists t_good;

drop table if exists t_keywords;

drop table if exists t_order;

drop table if exists t_order_detail;

drop table if exists t_product_pic;

drop table if exists t_root;

drop table if exists t_shop;

drop table if exists t_shop_good;

drop table if exists t_show_pic;

drop table if exists t_sms_identifying_code;

drop table if exists t_user;

drop table if exists t_user_good;

drop table if exists t_user_order;

/*==============================================================*/
/* Table: t_admin                                               */
/*==============================================================*/
create table t_admin
(
   id                   int not null,
   account              varchar(25) not null comment '账号',
   password             varchar(64) not null comment '密码',
   role                 tinyint not null comment '1代表超级管理员、2代表采购员、3代表店员',
   remarks              varchar(200) comment '备注',
   primary key (id)
);

alter table t_admin comment 't_admin';

/*==============================================================*/
/* Table: t_admin_shop                                          */
/*==============================================================*/
create table t_admin_shop
(
   shop_id              int,
   admin_id             int
);

alter table t_admin_shop comment 't_admin_shop';

/*==============================================================*/
/* Table: t_cart                                                */
/*==============================================================*/
create table t_cart
(
   id                   int not null,
   user_id              int not null comment '用户id',
   good_id              int not null comment '商品id',
   good_number          int not null comment '商品数量',
   primary key (id)
);

alter table t_cart comment 't_cart';

/*==============================================================*/
/* Table: t_category                                            */
/*==============================================================*/
create table t_category
(
   id                   int not null,
   name                 varchar(10) not null comment '商品种类名字',
   primary key (id)
);

alter table t_category comment 't_category';

/*==============================================================*/
/* Table: t_cookie_validate                                     */
/*==============================================================*/
create table t_cookie_validate
(
   id                   int not null,
   session_id           varchar(50) not null comment 'session产生的id',
   user_id              int not null comment '用户id',
   create_time          datetime not null comment 'cookie产生时间',
   primary key (id)
);

alter table t_cookie_validate comment 't_cookie_validate';

/*==============================================================*/
/* Table: t_good                                                */
/*==============================================================*/
create table t_good
(
   id                   int not null,
   name                 varchar(25) not null comment '商品名字',
   price                float(7,2) not null comment '商品价格',
   number               smallint not null comment '商品剩余数量',
   status               varchar(5) not null comment '商品状态',
   specification        varchar(25) not null comment '商品规格介绍',
   origin_place         varchar(25) not null comment '商品产地',
   pic_url              varchar(500) comment '首页图片',
   title                varchar(100) not null comment '展示标题',
   category_id          int not null comment '商品种类',
   sale_volume          int not null comment '销量',
   edible_method        varchar(20) comment '食用方式',
   storage              varchar(20) comment '存储方式',
   primary key (id)
);

alter table t_good comment 't_good';

/*==============================================================*/
/* Table: t_keywords                                            */
/*==============================================================*/
create table t_keywords
(
   id                   int not null,
   name                 varchar(50) not null comment '搜索关键字',
   count                int not null comment '搜索次数',
   primary key (id)
);

alter table t_keywords comment 't_keywords';

/*==============================================================*/
/* Table: t_order                                               */
/*==============================================================*/
create table t_order
(
   id                   int not null,
   status               varchar(5) not null comment '订单状态',
   total_price          float(7,2) not null comment '订单价格',
   reamarks             varchar(200) comment '订单备注',
   generated_time       datetime comment '生成订单时间',
   pay_time             datetime comment '付款时间',
   take_time            datetime comment '提取时间',
   shop_id              int comment '提取点id',
   primary key (id)
);

alter table t_order comment 't_order';

/*==============================================================*/
/* Table: t_order_detail                                        */
/*==============================================================*/
create table t_order_detail
(
   id                   int not null,
   order_id             int not null comment '订单id',
   good_id              int not null comment '商品id',
   good_number          int not null comment '商品数量',
   primary key (id)
);

alter table t_order_detail comment 't_order_detail';

/*==============================================================*/
/* Table: t_product_pic                                         */
/*==============================================================*/
create table t_product_pic
(
   id                   int not null,
   product_id           int not null comment '商品id',
   pic_url              varchar(500) not null comment '商品详情图片位置',
   type                 tinyint not null comment '图片类型：0代表轮廓图，1代表商品介绍图',
   primary key (id)
);

alter table t_product_pic comment 't_product_pic';

/*==============================================================*/
/* Table: t_root                                                */
/*==============================================================*/
create table t_root
(
   id                   int not null,
   account              varchar(50) comment '超级管理员账号',
   password             varchar(64) comment '密码',
   primary key (id)
);

alter table t_root comment 't_root';

/*==============================================================*/
/* Table: t_shop                                                */
/*==============================================================*/
create table t_shop
(
   id                   int not null,
   name                 varchar(100) not null comment '提取点名字',
   description          varchar(200) not null comment '提取点介绍',
   location             varchar(100) not null comment '提取点位置',
   is_default           tinyint comment '是否为默认提取点',
   primary key (id)
);

alter table t_shop comment 't_shop';

/*==============================================================*/
/* Table: t_shop_good                                           */
/*==============================================================*/
create table t_shop_good
(
   shop_id              int not null,
   good_id              int not null,
   primary key (shop_id, good_id)
);

alter table t_shop_good comment 't_shop_good';

/*==============================================================*/
/* Table: t_show_pic                                            */
/*==============================================================*/
create table t_show_pic
(
   id                   int not null,
   pic_url              varchar(500) not null comment '图片位置',
   type                 tinyint not null comment '展示位置',
   description          varchar(200) comment '图片描述',
   good_id              int comment '商品Id',
   primary key (id)
);

alter table t_show_pic comment 't_show_pic';

/*==============================================================*/
/* Table: t_sms_identifying_code                                */
/*==============================================================*/
create table t_sms_identifying_code
(
   id                   int not null,
   mobile               varchar(20) not null comment '手机号码',
   identifying_code     varchar(10) not null comment '验证码',
   create_time          datetime not null comment '生成时间',
   primary key (id)
);

alter table t_sms_identifying_code comment 't_sms_identifying_code';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   int not null,
   sex                  tinyint comment '性别',
   mobile               varchar(20) comment '手机号码',
   password             varchar(64) comment '密码',
   name                 varchar(20) comment '昵称',
   primary key (id)
);

alter table t_user comment 't_user';

/*==============================================================*/
/* Table: t_user_good                                           */
/*==============================================================*/
create table t_user_good
(
   user_id              int,
   good_id              int
);

alter table t_user_good comment 't_user_good';

/*==============================================================*/
/* Table: t_user_order                                          */
/*==============================================================*/
create table t_user_order
(
   user_id              int not null,
   order_id             int not null,
   primary key (user_id, order_id)
);

alter table t_user_order comment 't_user_order';

alter table t_admin_shop add constraint FK_Reference_10 foreign key (shop_id)
      references t_shop (id) on delete restrict on update restrict;

alter table t_admin_shop add constraint FK_Reference_11 foreign key (admin_id)
      references t_admin (id) on delete restrict on update restrict;

alter table t_cart add constraint FK_Reference_14 foreign key (good_id)
      references t_good (id) on delete restrict on update restrict;

alter table t_cart add constraint FK_Reference_15 foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_cookie_validate add constraint FK_Reference_16 foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_good add constraint FK_Reference_1 foreign key (category_id)
      references t_category (id) on delete restrict on update restrict;

alter table t_order add constraint FK_Reference_9 foreign key (shop_id)
      references t_shop (id) on delete restrict on update restrict;

alter table t_order_detail add constraint FK_Reference_7 foreign key (order_id)
      references t_order (id) on delete restrict on update restrict;

alter table t_order_detail add constraint FK_Reference_8 foreign key (good_id)
      references t_good (id) on delete restrict on update restrict;

alter table t_product_pic add constraint FK_Reference_2 foreign key (product_id)
      references t_good (id) on delete restrict on update restrict;

alter table t_shop_good add constraint FK_Reference_3 foreign key (shop_id)
      references t_shop (id) on delete restrict on update restrict;

alter table t_shop_good add constraint FK_Reference_4 foreign key (good_id)
      references t_good (id) on delete restrict on update restrict;

alter table t_show_pic add constraint FK_Reference_17 foreign key (good_id)
      references t_good (id) on delete restrict on update restrict;

alter table t_user_good add constraint FK_Reference_12 foreign key (good_id)
      references t_good (id) on delete restrict on update restrict;

alter table t_user_good add constraint FK_Reference_13 foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_user_order add constraint FK_Reference_5 foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_user_order add constraint FK_Reference_6 foreign key (order_id)
      references t_order (id) on delete restrict on update restrict;

