package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import com.example.demo.Entity.Voice;
import com.example.demo.Service.VoiceService;

// ------------------------------------------------------------------------
/*
    VoiceControllerはクライアント端末からの要求を受け取り、情報を返す処理を根底に実装する。
    また情報を返す際に、データを加工する処理も含む。
 
    Todo
        今はリクエストマッピングのアドレスは仮であり、ハードコーディングな為
        今後２次元管理が行える構造に持っていく必要がある
        クライアントアプリチームとの兼ね合いもある・・・
\                                    20180928 サーバーチーム 坂廼邉
*/
// ------------------------------------------------------------------------

@Controller
@RequestMapping("/voice")	
public class VoiceController {
	private static final String VIEW = "voice";

	@Autowired
	public VoiceService service;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		List<Voice> list = service.findAll();
		model.addAttribute("voices", list);
		return VIEW;
	}

    // --------------------------------------------------------------------
    // 音声データ追加
    // --------------------------------------------------------------------
	@RequestMapping(method = RequestMethod.POST)
	public String userList(Model mov, @RequestParam("voiceData") String voiceData) {
        // 文字列データのデータ長が1以上のデータのみ登録する。
        if(voiceData.length() > 0){
            Voice voice = new Voice();
            // データセット 日時
            java.util.Date nowTime = java.util.Calendar.getInstance().getTime();
            Date date = new Date(nowTime.getTime());
            voice.setDate(date);
            // データセット ユーザID
            Integer userID = 1; // 仮番号 今後置き換えます。
            voice.setUserid(userID);
            // データセット 音声データ
            voice.setVoice(voiceData);
            service.create(voice);
        }
		// 最新のデータをリストアップしてリダイレクト
		return index(mov);
	}
    // --------------------------------------------------------------------
    // 表示中蓄積音声データ　表示更新
    // --------------------------------------------------------------------
    @PostMapping(path = "update")
    String update(Model mov) {
        index(mov);
        return "redirect:/voice";
    }
    // --------------------------------------------------------------------
    // 音声データ　指定削除
    // --------------------------------------------------------------------
    @PostMapping(path = "select_delete")
    String select_delete(Model mov, @RequestParam("voiceID") String voiceID) {
        // IDが空白以外?
        if(voiceID.length() > 0){
            // 数値に変換
            int id = Integer.parseInt(voiceID);
            // 検索実行⇒検索結果がnull以外 ?
            if( service.FindOne(id) != null){
                // 検索結果データを削除する。
                service.Delete(id);
            }
        }
        return "redirect:/voice";
    }
    // --------------------------------------------------------------------
    // 音声データ　全削除
    // --------------------------------------------------------------------
    @PostMapping(path = "delete")
    String delete() {
        service.AllDelete();
        return "redirect:/voice";
    }
}
