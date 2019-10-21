package com.lyy.taskroot.service;

import com.github.pagehelper.Page;
import com.lyy.taskroot.po.MailDto;

import java.util.List;

public interface MailService {
   List<MailDto> selectNoDailyUser();
   Page<MailDto> getUserList();
   void sendMail(List<MailDto> list);
   void sendMailAttachFile(List<MailDto> list);
}
