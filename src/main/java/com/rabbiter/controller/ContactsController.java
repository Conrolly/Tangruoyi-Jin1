package com.rabbiter.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rabbiter.common.QueryPageParam;
import com.rabbiter.common.Result;
import com.rabbiter.entity.Contacts;
import com.rabbiter.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器：通讯录接口
 * </p>
 */
@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    /*
     * 新增
     * @author rabbiter
     * @date 2023/1/6 12:12
     */
    @PostMapping("/save")
    public Result save(@RequestBody Contacts contacts) {
        return contactsService.save(contacts) ? Result.success() : Result.fail();
    }

    /*
     * 更新
     * @author rabbiter
     * @date 2023/1/6 13:22
     */
    @PostMapping("/update")
    public Result update(@RequestBody Contacts contacts) {
        return contactsService.updateById(contacts) ? Result.success() : Result.fail();
    }

    /*
     * 删除
     * @author rabbiter
     * @date 2023/1/6 13:24
     */
    @GetMapping("/del")
    public Result del(@RequestParam String id) {
        return contactsService.removeById(id) ? Result.success() : Result.fail();
    }


    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        Page<Contacts> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());
        LambdaQueryWrapper<Contacts> queryWrapper = new LambdaQueryWrapper<>();

        IPage result = contactsService.pageCC(page, queryWrapper);
        List<Contacts> records = result.getRecords();
        return Result.success(records, result.getTotal());
    }
}
