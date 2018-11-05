/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/11/5 16:02:12                           */
/*==============================================================*/


drop table if exists PRM_PARTNER;

/*==============================================================*/
/* Table: PRM_PARTNER                                           */
/*==============================================================*/
create table PRM_PARTNER
(
   ID                   bigint not null comment '伙伴ID',
   PARTNER_NAME         varchar(50) not null comment '伙伴名称',
   COMPANY_ADDRESS      varchar(120) comment '公司地址',
   CONTACT              varchar(50) not null comment '联系方式',
   ORG_ID               bigint not null comment '组织ID',
   IS_ENABLED           bool not null default true comment '是否启用',
   SALESMAN_ID          bigint comment '业务员ID',
   REMARK               varchar(300) comment '备注',
   OP_ID                bigint not null comment '操作人ID',
   CREATE_TIME          datetime not null comment '创建时间',
   MODIFY_TIME          datetime not null comment '修改时间',
   primary key (ID)
);

alter table PRM_PARTNER comment '伙伴信息';

