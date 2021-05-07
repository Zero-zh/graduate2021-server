package com.graduate.loyee.service;

import com.graduate.loyee.entity.Campus;
import com.graduate.loyee.entity.Epidemic;
import com.graduate.loyee.mapper.CampusMapper;
import com.graduate.loyee.mapper.EpidemicMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BroadcastService {

    @Autowired
    private CampusMapper campusMapper;

    @Autowired
    private EpidemicMapper epidemicMapper;

    public List<Campus> getinfoData() {
        Campus parm = new Campus();
        parm.setStatus(0);
        parm.setType(1);
        List<Campus> campuses = campusMapper.selectByCondition(parm);
        return campuses;
    }

    public List<Campus> getResearchData() {
        Campus parm = new Campus();
        parm.setStatus(0);
        parm.setType(2);
        List<Campus> campuses = campusMapper.selectByCondition(parm);
        return campuses;
    }

    public List<Campus> getHistoryData() {
        Campus parm = new Campus();
        parm.setStatus(0);
        List<Campus> campuses = campusMapper.selectHistoryData(parm);
        return campuses;
    }

    public List<Epidemic> getEpidemicData(Integer type) {
        Epidemic parm = new Epidemic();
        parm.setStatus(0);
        parm.setType(type);
        List<Epidemic> campuses = epidemicMapper.getEpidemicData(parm);
        return campuses;
    }

}
