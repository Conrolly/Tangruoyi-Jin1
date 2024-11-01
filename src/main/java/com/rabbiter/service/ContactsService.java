package com.rabbiter.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rabbiter.entity.Contacts;


public interface ContactsService extends IService<Contacts> {
    IPage pageCC(IPage<Contacts> page, Wrapper wrapper);

}
