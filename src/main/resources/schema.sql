create table VEHICLE(
    SEQ bigint not null auto_increment comment '시퀀스',
    VIN varchar(50) not null comment '차대번호',
    CREATED_AT timestamp not null comment '생성일시',
    UPDATED_AT timestamp  comment '수정일시',
    primary key(`SEQ`)
);