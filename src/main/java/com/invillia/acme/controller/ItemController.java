package com.invillia.acme.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.entity.Item;
import com.invillia.acme.helpers.JsonReturn;
import com.invillia.acme.repository.ItemRepository;

@RestController
public class ItemController {
	@Autowired
	private ItemRepository _itemRepository;

	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public JsonReturn<Item> GetById(@PathVariable(value = "id") long id) {
		JsonReturn<Item> result = new JsonReturn<Item>();
		try {
			Optional<Item> item = _itemRepository.findById(id);
			if (item.isPresent()) {
				result.SetSuccess(item.get());
			} else {
				result.SetNotFound(null);
			}
		} catch (Exception ex) {
			result.SetException(ex);
			result.SetException(ex, new Item(id));
		}
		return result;
	}

	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public JsonReturn<Item> Post(@Valid @RequestBody Item item) {
		JsonReturn<Item> result = new JsonReturn<Item>();
		try {
			result.SetSuccess(_itemRepository.save(item));
		} catch (Exception ex) {
			result.SetException(ex, null);
		}
		return result;
	}

	@RequestMapping(value = "/item/{id}", method = RequestMethod.PUT)
	public JsonReturn<Item> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Item newItem) {
		JsonReturn<Item> result = new JsonReturn<Item>();
		try {
			Optional<Item> oldItem = _itemRepository.findById(id);
			if (oldItem.isPresent()) {
				Item item = oldItem.get();
				//item.setPurchaseOrder(newItem.getPurchaseOrder().getPurchaseorderid());
				item.setDescription(newItem.getDescription());
				item.setUnitprice(newItem.getUnitprice());
				item.setQuantity(newItem.getQuantity());
				result.SetSuccess(_itemRepository.save(item));
			} else {
				result.SetNotFound(null);
			}
		} catch (Exception ex) {
			result.SetException(ex);
			result.SetException(ex, new Item(id));
		}
		return result;
	}
}
