package com.hx.ants.grok;

import io.krakens.grok.api.Grok;
import io.krakens.grok.api.GrokCompiler;
import io.krakens.grok.api.Match;

import java.util.Map;

/**
 * @Author lyy
 * @Description grok logs
 * @Date 2019-12-04
 **/
public class GrokApplication {
	public static void main(String[] args) {
		/* Create a new grokCompiler instance */
		GrokCompiler grokCompiler = GrokCompiler.newInstance();
		grokCompiler.registerDefaultPatterns();

		/* Grok pattern to compile, here httpd logs */
		final Grok grok = grokCompiler.compile("(?m)(?<ErrMsg>.*\\\\R.*)\"");

		/* Line of log to match */
		String log = "[#%&*^]20191203150002:762.vm-vmw43304-tod!TLH:MATIP.114037,140255531022080#TLHLCZOU032019120315000235718800%1&11EZASLR_P57B94A_W*NA^:STAT_IN> \n" +
				"OriSys=EXSYS;DesSys=TLH;IATAOri=11EZASLQ;IATADes=11EZASLR;TPR=P57B94A;TLHH1H2=FF01;FlowID=00;\n" +
				"V.\n" +
				"VHLG.WA/E11EZASLQ/I11EZASLR/P57B94A\n" +
				"VGYA\n" +
				"UNB+IATA:1+9E1E1E1E+ZA+191203:1500+359316'UNH+1+PAOREQ:96:2:IA+P1275624AA'MSG+1:46'ORG+1E:BJS+:SZV122+SZV+++CN'ODI+CTU+KOS'TVL+101219+CTU+KOS+ZA+494+1+1+P'UNT+6+1'UNZ+1+359316'\n";


		Match gm = grok.match(log);

		/* Get the map with matches */
		final Map<String, Object> capture = gm.capture();
	}
}
