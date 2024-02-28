package bupt.whx.chatbot.api.domain.zsxq;

import bupt.whx.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * ClassName:ZsxqApi
 * Package:bupt.whx.chatbot.api.domain.zsxq
 * Description:  知识星球api接口
 *
 * @Author whx
 * @Create 2024/2/28 23:15
 * @Version 1.0
 */
public interface IZsxqApi {

    /**
     * 返回未回答的问题数据
     * @param groupId
     * @param cookie
     * @return
     * @throws IOException
     */
    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException;

    boolean answer(String groupId,String cookie,String topicId,String text,boolean silenced) throws IOException;
}
