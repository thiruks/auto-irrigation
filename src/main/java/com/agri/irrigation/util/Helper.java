package com.agri.irrigation.util;

import com.agri.irrigation.model.Plot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.agri.irrigation.util.Constant.SPLITTER_COMMA;

@Component
public class Helper {

    private static final Logger LOG = LoggerFactory.getLogger(Helper.class);

    public List<String> getList(String s){
        List<String> res = new ArrayList<>();
        if(s != null && !s.trim().isEmpty()){
            res = Arrays.asList(s.split(SPLITTER_COMMA));
        }
        return res;
    }

    public void generateFile(List<Plot> aP, String fileName, String fileType) {
        String fileHeader = Constant.FILE_HEADER;
        if(!fileName.trim().isEmpty() && !fileHeader.trim().isEmpty()){
            File csvOutputFile = new File(fileName);

            try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
                pw.write(fileHeader);
                pw.write(getValue(aP));
                LOG.info("{} report generated: {}", fileType, csvOutputFile);
            }
            catch (Exception e){
                //
            }
        }
    }

    private String getValue(List<Plot> aP){
        StringBuilder sB = new StringBuilder();
        for(Plot p : aP){
            sB.append(p.getId()+Constant.SPLITTER_COMMA);
            sB.append(p.getNo()+Constant.SPLITTER_COMMA);
            sB.append(p.getHasSensor()+Constant.SPLITTER_COMMA);
            sB.append(p.getRetryCount()+Constant.SPLITTER_COMMA);
            sB.append(p.getTimeSlot()+Constant.SPLITTER_COMMA);
            sB.append(p.getIsIrrigated()+Constant.SPLITTER_COMMA);
            sB.append(p.getWaterQty()+Constant.WATER_QTY+Constant.SPLITTER_COMMA);
            sB.append(p.getCropType()+Constant.SPLITTER_COMMA);
            sB.append(p.getCultivatedArea()+Constant.PLOT_AREA);
            sB.append(Constant.NEW_LINE);
        }
        return sB.toString();
    }
}
