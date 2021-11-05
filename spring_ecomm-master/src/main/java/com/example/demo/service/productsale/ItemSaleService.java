package com.example.demo.service.productsale;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemSale;
import com.example.demo.respositories.ItemResponsitory;
import com.example.demo.respositories.ItemSaleResponsitory;

public interface ItemSaleService {

	void deleteAll();

	void deleteAll(List<ItemSale> entities);

	void delete(ItemSale entity);

	void deleteById(Integer id);

	long count();

	List<ItemSale> findAllById(List<Integer> ids);

	List<ItemSale> findAll();

	boolean existsById(Integer id);

	Optional<ItemSale> findById(Integer id);

	List<ItemSale> saveAll(List<ItemSale> entities);

	ItemSale save(ItemSale entity);

	

}
