package com.laptrinhjavaweb.converter;

import java.util.List;

/**
 * @author Duy Dung
 *
 * @param <T return Model>
 * @param <E return Entity>
 */
public interface IConvert<T,E> {
	E toEntity (T model);
	E toEntity (T model, E entity);
	T toModel(E entity);
}
