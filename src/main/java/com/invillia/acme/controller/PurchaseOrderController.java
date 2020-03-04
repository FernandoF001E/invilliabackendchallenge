package com.invillia.acme.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.entity.PurchaseOrder;
import com.invillia.acme.entity.Store;
import com.invillia.acme.helpers.JsonReturn;
import com.invillia.acme.repository.PurchaseOrderRepository;

@RestController
public class PurchaseOrderController {
	@Autowired
	private PurchaseOrderRepository _orderRepository;

	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	public JsonReturn<PurchaseOrder> GetById(@PathVariable(value = "id") long id) {
		JsonReturn<PurchaseOrder> result = new JsonReturn<PurchaseOrder>();
		try {
			Optional<PurchaseOrder> order = _orderRepository.findById(id);
			if (order.isPresent()) {
				result.SetSuccess(order.get());
			} else {
				result.SetNotFound(null);
			}
		} catch (Exception ex) {
			result.SetException(ex);
			result.SetException(ex, new PurchaseOrder(id));
		}
		return result;
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public JsonReturn<PurchaseOrder> Post(@Valid @RequestBody PurchaseOrder order) {
		JsonReturn<PurchaseOrder> result = new JsonReturn<PurchaseOrder>();
		try {
			result.SetSuccess(_orderRepository.save(order));
		} catch (Exception ex) {
			result.SetException(ex, null);
		}
		return result;
	}

	@RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
	public JsonReturn<PurchaseOrder> Put(@PathVariable(value = "id") long id,
			@Valid @RequestBody PurchaseOrder newOrder) {
		JsonReturn<PurchaseOrder> result = new JsonReturn<PurchaseOrder>();
		try {
			Optional<PurchaseOrder> oldOrder = _orderRepository.findById(id);
			if (oldOrder.isPresent()) {
				PurchaseOrder order = oldOrder.get();
				Store store = new Store(4);
				order.setStore(store);
				order.setAddress(newOrder.getAddress());
				order.setConfirmationdate(newOrder.getConfirmationdate());
				order.setStatus(newOrder.getStatus());
				result.SetSuccess(_orderRepository.save(order));
			} else {
				result.SetNotFound(null);
			}
		} catch (Exception ex) {
			result.SetException(ex);
			result.SetException(ex, new PurchaseOrder(id));
		}
		return result;
	}
}
