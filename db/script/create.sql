/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/5/15 16:35:55                           */
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
   ORG_ID               bigint comment '组织ID
            当前伙伴的组织ID，添加伙伴时，先在组织表中查找有没有相同名称的组织，如果有，直接关联过来；如果没有，先添加新的组织，再关联过来',
   IS_ENABLED           bool not null default true comment '是否启用',
   SALESMAN_ID          bigint comment '业务员ID',
   REMARK               varchar(300) comment '备注',
   OP_ID                bigint not null comment '操作人ID',
   OP_ORG_ID            bigint not null comment '所属组织
            添加伙伴时，取当前用户的组织ID设置进来',
   CREATE_TIME          datetime not null comment '创建时间',
   MODIFY_TIME          datetime not null comment '修改时间',
   primary key (ID),
   unique key AK_OP_ORG_AND_PARTNER_NAME (PARTNER_NAME, OP_ORG_ID)
);

alter table PRM_PARTNER comment '伙伴信息';

