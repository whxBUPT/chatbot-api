package bupt.whx.chatbot.api.domain.zsxq.service;

import bupt.whx.chatbot.api.domain.zsxq.IZsxqApi;
import bupt.whx.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
*ClassName:ZsxqApi
*Package:bupt.whx.chatbot.api.domain.zsxq.service
*Description:
*@Author whx
*@Create 2024/2/28 23:28
*@Version 1.0
*/
public class ZsxqApi implements IZsxqApi {

    @Override
    public UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException {
        return null;
    }

    @Override
    public boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException {
        return false;
    }
}
