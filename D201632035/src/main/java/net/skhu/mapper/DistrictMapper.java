package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.District;

@Mapper
public interface DistrictMapper {

    List<District> findAll();
}

