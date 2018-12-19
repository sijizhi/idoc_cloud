package com.tongfu.idoc.file.controller;

import com.tongfu.idoc.file.utils.ResultData;
import com.tongfu.idoc.file.utils.UserUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/12/19 15:13
 */
@RestController
@RequestMapping("/api/power")
public class FileController {

    private  Map<String,Object> map;
    /**
     * 测试文件权限
     * @param docId
     * @return
     * @throws Exception
     */
    @RequestMapping("/idoc_file")
    public ResultData test(int docId) throws  Exception{
        if(UserUtils.getUser().getId()==docId){
            map=new HashMap<>();
            map.put("content","授权文件的id是:"+docId );
            return new ResultData(200, "已授权",map);
        }
        return new ResultData(550, "未授权");
    }
}
