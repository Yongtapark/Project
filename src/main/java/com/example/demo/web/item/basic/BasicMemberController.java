package com.example.demo.web.item.basic;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.register;
import com.example.demo.domain.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/members")
@RequiredArgsConstructor
public class BasicMemberController {

    private final MembersRepository membersRepository;

    @GetMapping
    public String members(Model model){
        List<Member> members = membersRepository.findAll();
        model.addAttribute("members",members);
        return "basic/members";
    }



    @GetMapping("/{memberId}")
    public String member(@PathVariable Long memberId, Model model){
        Member member = membersRepository.findById(memberId);
        model.addAttribute("member",member);
        return "basic/member";
    }

    @GetMapping("/add")
    public String addForm(){
        return "basic/addForm";
    }

    @PostMapping("/add")
    public String addMember(@ModelAttribute Member member, RedirectAttributes redirectAttributes){
        Member savedMember = membersRepository.save(member);
        redirectAttributes.addFlashAttribute("memberId",savedMember.getId());
        redirectAttributes.addFlashAttribute("status",true);
        return "redirect:/basic/members";
    }

    @GetMapping("/{memberId}/edit")
    public String editForm(@PathVariable Long memberId, Model model){
        Member member = membersRepository.findById(memberId);
        model.addAttribute("member",member);
        return "basic/editForm";
    }

    @PostMapping("/{memberId}/edit")
    public String edit(@PathVariable Long memberId, @ModelAttribute Member member){
        membersRepository.update(memberId,member);
        return "redirect:/basic/members/{memberId}";
    }

    @PostConstruct
    public void init(){
        membersRepository.save(new Member("김재현", register.주_7회));
        membersRepository.save(new Member("박용타",register.주_3회));
    }



}
