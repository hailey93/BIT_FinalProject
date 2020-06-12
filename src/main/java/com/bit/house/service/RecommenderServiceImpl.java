package com.bit.house.service;

import com.bit.house.domain.ProductVO;
import com.bit.house.domain.RecommenderVO;
import com.bit.house.mapper.RecommenderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class RecommenderServiceImpl implements RecommenderService {

    @Autowired(required = false)
    RecommenderMapper recommenderMapper;

    @Override
    public List<String> selectClickProductById() {
        List<RecommenderVO> recommenderVO = recommenderMapper.selectClickProductById();

        List<String> clickLists = new ArrayList();
        List<String> clickList = null;

        for (RecommenderVO products : recommenderVO) {
            clickList = new ArrayList<String>();
            for (ProductVO productNo2 : products.getProductVO()) {
                clickList.add(productNo2.getProductNo());
            }
            clickList.toString();
            clickLists.add(clickList.toString());
        }

        return clickLists;
    }

    /*@Override
    public String selectClickProduct(String memberId) {
        //인풋데이터 전처리
        return recommenderMapper.selectClickProduct().toUpperCase();
    }*/
    @Override
    public String selectClickProduct() {
        //인풋데이터 전처리
        return recommenderMapper.selectClickProduct();
    }

    @Override
    public List<ProductVO> selectProductList(Collection<String> productNos) {
        List<ProductVO> recommendList=new ArrayList();
        //추천시스템으로부터 가져온 productNo들을 product테이블에 넣어 디테일 가져오기
        for(String productNo:productNos){
            recommendList.add(recommenderMapper.selectProductDetail(productNo));
        }
        return recommendList;
    }

}