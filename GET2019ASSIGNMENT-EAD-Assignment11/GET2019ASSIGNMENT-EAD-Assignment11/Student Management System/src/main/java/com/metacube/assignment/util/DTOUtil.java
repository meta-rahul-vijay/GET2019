package com.metacube.assignment.util;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Sabir
 *
 */
@Component
public class DTOUtil {

	public static ModelMapper mapper;
	/**
	 * 
	 * @param modelMapper
	 */
	@Autowired
	public DTOUtil(ModelMapper modelMapper) {
		mapper = modelMapper;
	}
	/**
	 * 
	 * @param <S>
	 * @param <T>
	 * @param source
	 * @param targetClass
	 * @return
	 */
	public static <S, T> T map(S source, Class<T> targetClass) {
		return mapper.map(source, targetClass);
	}
	/**
	 * 
	 * @param <S>
	 * @param <T>
	 * @param source
	 * @param dist
	 */
	public static <S, T> void mapTo(S source, T dist) {
		mapper.map(source, dist);
	}
	/**
	 * 
	 * @param <S>
	 * @param <T>
	 * @param source
	 * @param targetClass
	 * @return
	 */
	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		List<T> list = new ArrayList<>();
		for (S s : source) {
			list.add(mapper.map(s, targetClass));
		}
		return list;
	}
}