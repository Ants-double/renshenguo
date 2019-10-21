package com.lyy.taskroot.mapper;

import com.github.pagehelper.Page;
import com.lyy.taskroot.po.MialEntity;

import java.util.List;

public interface MailMapper {
   List<MialEntity> selectNoDailyUser();

   Page<MialEntity> getUserList();
}
