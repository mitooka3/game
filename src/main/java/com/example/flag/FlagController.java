package com.example.flag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class FlagController {
	//変数session
		@Autowired
		HttpSession session;
		int count;
		String comment;
		int rightAns;
		String correct;
		
		//初期表示・もう一度ボタン
		@GetMapping("/")
		public String index() {
			//セッション内クリア
			session.invalidate();  
			return "opening";
		}
		
		@GetMapping("/game")
		public ModelAndView game(ModelAndView mv) {
			Game mondai = new Game();
			session.setAttribute("mondai", mondai);
			session.setAttribute("correct", mondai.getName());
			
			mv.setViewName("game");
			mv.addObject("mondai", mondai);
			return mv;
		}
		
		@GetMapping("/answer/{number}")
		public ModelAndView answer(@PathVariable(name = "answer")String answer,ModelAndView mv) {
			count = (Integer)session.getAttribute("count");
			count++;
			correct = (String)session.getAttribute("correct");
				
			if(count >= 10) {
				mv.setViewName("end");
				mv.addObject("rightAns",rightAns);
				return mv;
			}else {
				if(answer == correct) {
					comment = "正解です！";
					rightAns = (Integer)session.getAttribute("rightAns");
					rightAns++;
					session.setAttribute("rightAns", rightAns);
					session.setAttribute("count", count);
					
					mv.setViewName("game");
					mv.addObject("comment", comment);
					return mv;
					
				}else {
					comment = "ざんねん！！不正解　　こたえは " + correct  + " でした";
					mv.setViewName("game");
					mv.addObject("comment", comment);
					return mv;
				}
			}
		}

}
