/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/10/25 9:11:45                           */
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
   PARTNER_TYPE         tinyint not null comment '伙伴类型',
   IS_ENABLED           bool not null default true comment '是否启用',
   SALESMAN_ID          bigint comment '业务员ID',
   REMARK               varchar(300) comment '备注',
   CREATE_TIME          datetime not null comment '创建时间',
   primary key (ID)
);

alter table PRM_PARTNER comment '伙伴信息';

