/**
 * TextCutDirective.java	  V1.0   Jun 20, 2013 3:26:40 PM
 *
 * Copyright GTA Information System Co. ,Ltd. All rights reserved.
 *
 * Modification history(By    Time    Reason):
 * 
 * Description:
 */

package com.gta.oec.controller.directive;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import com.gta.oec.common.web.frermarker.DirectiveUtils;
import com.gta.oec.util.StrUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
/**
 * 
 * 功能描述:截取html转为text后的文本.
 *
 * @author  dongs
 *
 * <p>修改历史：(修改人，修改时间，修改原因/内容)</p>
 */
public class HtmlUnesacapeCutDirective implements TemplateDirectiveModel {
	//例如 <div id="testDiv">&lt;test&gt;1&lt;1&gt;0;test2</div> 截取 len = 4 append= ..  结果 <tes..
	public static final String PARAM_S = "s";//字符串
	public static final String PARAM_LEN = "len";//截取长度
	public static final String PARAM_APPEND = "append";//拼接内容
     
	@SuppressWarnings("unchecked")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		String s = DirectiveUtils.getString(PARAM_S, params);
		Integer len = DirectiveUtils.getInt(PARAM_LEN, params);
		String append = DirectiveUtils.getString(PARAM_APPEND, params);
		if (s != null) {
			Writer out = env.getOut();
			if (len != null) {
				out.append(StrUtils.htmlUnescapeCut(s, len, append));
			} else {
				out.append(StrUtils.htmlUnescapeToText(s));
			}
		}
	}
}
