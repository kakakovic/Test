package com.dsy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.lucene.util.RamUsageEstimator;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

public class LoadFile {
    public static void main(String[] args) throws Exception{
        //System.out.println(getDsBefore("20200110", 2));
        //
        //PgcDataDO x = new PgcDataDO().withDefaultSet();
        //System.out.println(RamUsageEstimator.humanSizeOf(x));
        Object x = null;
        System.out.println(Integer.valueOf(1).equals(null));
    }


    private static String getDsBefore(String ds, int before) throws Exception{
        Date date = FastDateFormat.getInstance("yyyyMMdd").parse(ds);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, before);
        date = calendar.getTime();
        return FastDateFormat.getInstance("yyyyMMdd").format(date);
    }

    public static class PgcDataDO{
        private String ds;
        private Long ytid;

        private Long commentTotal;
        private Long upTotal;
        private Long shareTotal;
        private Long vvTotal;
        private Double tsTotal;
        private Long fansAcc;

        //二次计算指标
        private Double commentTotalRr;
        private Double commentTotalWr;
        private Double upTotalRr;
        private Double upTotalWr;
        private Double shareTotalRr;
        private Double shareTotalWr;
        private Double vvTotalRr;
        private Double vvTotalWr;
        private Double tsTotalRr;
        private Double tsTotalWr;
        private Double fansAccRr;
        private Double fansAccWr;

        public String getDs() {
            return ds;
        }

        public void setDs(String ds) {
            this.ds = ds;
        }

        public Long getYtid() {
            return ytid;
        }

        public void setYtid(Long ytid) {
            this.ytid = ytid;
        }

        public Long getCommentTotal() {
            return commentTotal;
        }

        public void setCommentTotal(Long commentTotal) {
            this.commentTotal = commentTotal;
        }

        public Long getUpTotal() {
            return upTotal;
        }

        public void setUpTotal(Long upTotal) {
            this.upTotal = upTotal;
        }

        public Long getShareTotal() {
            return shareTotal;
        }

        public void setShareTotal(Long shareTotal) {
            this.shareTotal = shareTotal;
        }

        public Long getVvTotal() {
            return vvTotal;
        }

        public void setVvTotal(Long vvTotal) {
            this.vvTotal = vvTotal;
        }

        public Double getTsTotal() {
            return tsTotal;
        }

        public void setTsTotal(Double tsTotal) {
            this.tsTotal = tsTotal;
        }

        public Long getFansAcc() {
            return fansAcc;
        }

        public void setFansAcc(Long fansAcc) {
            this.fansAcc = fansAcc;
        }

        public Double getCommentTotalRr() {
            return commentTotalRr;
        }

        public void setCommentTotalRr(Double commentTotalRr) {
            this.commentTotalRr = commentTotalRr;
        }

        public Double getCommentTotalWr() {
            return commentTotalWr;
        }

        public void setCommentTotalWr(Double commentTotalWr) {
            this.commentTotalWr = commentTotalWr;
        }

        public Double getUpTotalRr() {
            return upTotalRr;
        }

        public void setUpTotalRr(Double upTotalRr) {
            this.upTotalRr = upTotalRr;
        }

        public Double getUpTotalWr() {
            return upTotalWr;
        }

        public void setUpTotalWr(Double upTotalWr) {
            this.upTotalWr = upTotalWr;
        }

        public Double getShareTotalRr() {
            return shareTotalRr;
        }

        public void setShareTotalRr(Double shareTotalRr) {
            this.shareTotalRr = shareTotalRr;
        }

        public Double getShareTotalWr() {
            return shareTotalWr;
        }

        public void setShareTotalWr(Double shareTotalWr) {
            this.shareTotalWr = shareTotalWr;
        }

        public Double getVvTotalRr() {
            return vvTotalRr;
        }

        public void setVvTotalRr(Double vvTotalRr) {
            this.vvTotalRr = vvTotalRr;
        }

        public Double getVvTotalWr() {
            return vvTotalWr;
        }

        public void setVvTotalWr(Double vvTotalWr) {
            this.vvTotalWr = vvTotalWr;
        }

        public Double getTsTotalRr() {
            return tsTotalRr;
        }

        public void setTsTotalRr(Double tsTotalRr) {
            this.tsTotalRr = tsTotalRr;
        }

        public Double getTsTotalWr() {
            return tsTotalWr;
        }

        public void setTsTotalWr(Double tsTotalWr) {
            this.tsTotalWr = tsTotalWr;
        }

        public Double getFansAccRr() {
            return fansAccRr;
        }

        public void setFansAccRr(Double fansAccRr) {
            this.fansAccRr = fansAccRr;
        }

        public Double getFansAccWr() {
            return fansAccWr;
        }

        public void setFansAccWr(Double fansAccWr) {
            this.fansAccWr = fansAccWr;
        }

        public PgcDataDO withDefaultSet(){
            this.setCommentTotal(0L);
            this.setUpTotal(0L);
            this.setShareTotal(0L);
            this.setVvTotal(0L);
            this.setTsTotal(0d);
            this.setFansAcc(0L);


            //二次计算指标
            this.setCommentTotalRr(0d);
            this.setCommentTotalWr(0d);

            this.setUpTotalRr(0d);
            this.setUpTotalWr(0d);

            this.setShareTotalRr(0d);
            this.setShareTotalWr(0d);

            this.setVvTotalRr(0d);
            this.setVvTotalWr(0d);

            this.setTsTotalRr(0d);
            this.setTsTotalWr(0d);

            this.setFansAccRr(0d);
            this.setFansAccWr(0d);

            return this;
        }
    }


}
