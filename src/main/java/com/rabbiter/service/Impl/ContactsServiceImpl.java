package com.rabbiter.service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rabbiter.entity.Contacts;
import com.rabbiter.mapper.ContactsMapper;
import com.rabbiter.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactsServiceImpl extends ServiceImpl<ContactsMapper, Contacts> implements ContactsService {
    @Autowired
    private ContactsMapper contactsMapper;

    @Override
    public IPage pageCC(IPage<Contacts> page, Wrapper wrapper) {
        return contactsMapper.pageCC(page, wrapper);
    }


}
