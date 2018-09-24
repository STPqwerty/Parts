package my.internship.parts.controller;

import my.internship.parts.dao.PartRepo;
import my.internship.parts.model.Parts;
import my.internship.parts.model.PartsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.parser.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PartController {
	@Autowired
	private PartRepo _repository;

	List<Parts> parts = new ArrayList<Parts>();
	List<Integer> pages = new ArrayList<Integer>();
	final int PAGE_SIZE = 10;
	int CURRENT_PAGE = 1;

	@GetMapping(value = {"/{page}", "/"})
	public String main(@PathVariable(required = false) Integer page, Model model) {
		parts = _repository.GetParts();

		PartsModel partModel = new PartsModel();
		int start = 0;
		int arraySize = parts.size();
		int pagesAmount =(int) Math.ceil((double) arraySize / PAGE_SIZE);
		pages.clear();
		
		for(int i = 0; i < pagesAmount; i++ ) {
			pages.add(i+1);
		}

		if (page != null) {
			start = (page - 1) * PAGE_SIZE + 1;
			if (start <= 1) {
				start = 0;
			}
		} else {
			page = 1;
		}

		int end = start + PAGE_SIZE;

		if (end > arraySize) {
			end = arraySize;
		}

		partModel.setParts(parts.subList(start, end));
		partModel.setCompCount(availiableComps(parts));
	
		model.addAttribute("model", partModel);
		model.addAttribute("curentPage", pages);
		return "index";
	}

	int availiableComps(List<Parts> list) {
		int amount = Integer.MAX_VALUE;

		for (Parts p : list) {
			if (p.isRequared()) {
				amount = Math.min(amount, p.getCount());
			}
		}
		return amount;
	}
}
