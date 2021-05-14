package com.graduate.loyee.service;

import com.graduate.loyee.entity.AskAnswer;
import com.graduate.loyee.entity.Experience;
import com.graduate.loyee.mapper.AskAnswerMapper;
import com.graduate.loyee.mapper.ExperienceMapper;
import com.graduate.loyee.utils.IdWorker.IdWorker;
import com.graduate.loyee.utils.redis.RedisUtil;
import com.graduate.loyee.vo.BaseVo.PageOutputVo;
import com.graduate.loyee.vo.QAndAVo.AskQuestionVo;
import com.graduate.loyee.vo.QAndAVo.QueryAskAnswerVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class QAndAService {
    @Autowired
    private ExperienceMapper experienceMapper;
    @Autowired
    private AskAnswerMapper askAnswerMapper;

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private IdWorker idWorker = new IdWorker(0,0);

    public PageOutputVo<List<AskAnswer>> getAskAndAnswerData(QueryAskAnswerVo para) {
        PageOutputVo<List<AskAnswer>> result = new PageOutputVo<>();
        if(StringUtils.isEmpty(para.getType()))
            para.setType(null);
        if(StringUtils.isEmpty(para.getContent()))
            para.setContent(null);
        if( StringUtils.isEmpty(para.getShowRowsPerPage())){
            para.setShowRowsPerPage(10);
        }
        if(StringUtils.isEmpty(para.getCurrentPage())){
            para.setCurrentPage(0);
        }else{
            para.setCurrentPage((para.getCurrentPage() -1) * para.getShowRowsPerPage());
        }

        List<AskAnswer> askAnswerList = askAnswerMapper.getAskAndAnswerData(para);
        for (AskAnswer answer : askAnswerList) {
            answer.setTime(answer.getTime().split("\\.")[0]);
        }
        if(askAnswerList.size() > 0){
            Integer count = askAnswerMapper.selectRowCount(para);
            result.setRowsCount(count);
            Double temp = Math.ceil(new Double(count) / new Double(para.getShowRowsPerPage()));
            result.setPageCount(temp.intValue());
        }
        result.setT(askAnswerList);
        return result;
    }

    public List<Experience> getWorkExperience(QueryAskAnswerVo para) {
        PageOutputVo<List<Experience>> result = new PageOutputVo<>();
        if(StringUtils.isEmpty(para.getType()))
            para.setType(null);
        if(StringUtils.isEmpty(para.getContent()))
            para.setContent(null);
        if( StringUtils.isEmpty(para.getShowRowsPerPage())){
            para.setShowRowsPerPage(10);
        }
        if(StringUtils.isEmpty(para.getCurrentPage())){
            para.setCurrentPage(0);
        }else{
            para.setCurrentPage((para.getCurrentPage() -1) * para.getShowRowsPerPage());
        }
        List<Experience> workExperienceList = experienceMapper.getWorkExperience(para);
        return workExperienceList;
    }

    public List<AskAnswer> askQuestion(AskQuestionVo para) throws Exception {
        if(StringUtils.isEmpty(para.getType()))
            para.setType(null);
        if(StringUtils.isEmpty(para.getDesc()))
            para.setDesc(null);
        if(StringUtils.isEmpty(para.getRemarks()))
            para.setRemarks(null);
        if(StringUtils.isEmpty(para.getTitle()))
            para.setTitle(null);
        AskAnswer question = new AskAnswer();
        BeanUtils.copyProperties(para,question);
        question.setStatus(0);
        question.setAuthor(RedisUtil.get("username").toString());
        List<AskAnswer> askAnswerList = askAnswerMapper.selectByCondition(question);
        if (askAnswerList.size() > 0){
            throw new Exception("数据库中已经存在该数据,新增失败");
        }
        question.setId(idWorker.nextId()+"");
        question.setTime(df.format(new Date()));
        question.setReplyNums(0);
        int row = askAnswerMapper.insert(question);
        if(row < 1)
            throw new Exception("插入数据失败");
        return null;
    }

    public List<AskAnswer> deleteAskQuestion(String questionId) throws Exception {
        AskAnswer question = new AskAnswer();
        question.setId(questionId);
        question.setStatus(1);
        int row = askAnswerMapper.updateByPrimaryKeySelective(question);
        if(row < 1)
            throw new Exception("删除数据失败");
        return null;
    }


    public List<AskAnswer> updateAskQuestion(AskAnswer para) throws Exception {

        int row = askAnswerMapper.updateByPrimaryKeySelective(para);
        if(row < 1)
            throw new Exception("更新数据失败");
        return null;
    }

}
