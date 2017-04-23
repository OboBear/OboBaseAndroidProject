package com.me.obo.flurryjason;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by obo on 2017/1/9.
 * Email:obo.lin@dingtone.me
 */

public class Test {

    private static String inputString = "[\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.03\",\n" +
            "    \"country\" : \"Unknown\",\n" +
            "    \"clicks\" : \"3\",\n" +
            "    \"impressions\" : \"30\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"204.33\",\n" +
            "    \"country\" : \"US\",\n" +
            "    \"clicks\" : \"3700\",\n" +
            "    \"impressions\" : \"134684\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.09\",\n" +
            "    \"country\" : \"AF\",\n" +
            "    \"clicks\" : \"27\",\n" +
            "    \"impressions\" : \"88\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"AG\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.95\",\n" +
            "    \"country\" : \"AR\",\n" +
            "    \"clicks\" : \"38\",\n" +
            "    \"impressions\" : \"436\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.11\",\n" +
            "    \"country\" : \"AO\",\n" +
            "    \"clicks\" : \"4\",\n" +
            "    \"impressions\" : \"19\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"AI\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"AS\",\n" +
            "    \"clicks\" : \"2\",\n" +
            "    \"impressions\" : \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"AD\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"8\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"AL\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"68\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.15\",\n" +
            "    \"country\" : \"DZ\",\n" +
            "    \"clicks\" : \"19\",\n" +
            "    \"impressions\" : \"161\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"1.54\",\n" +
            "    \"country\" : \"BH\",\n" +
            "    \"clicks\" : \"204\",\n" +
            "    \"impressions\" : \"1783\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"6.40\",\n" +
            "    \"country\" : \"BD\",\n" +
            "    \"clicks\" : \"612\",\n" +
            "    \"impressions\" : \"4399\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.08\",\n" +
            "    \"country\" : \"AZ\",\n" +
            "    \"clicks\" : \"5\",\n" +
            "    \"impressions\" : \"32\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"BS\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"28\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"2.65\",\n" +
            "    \"country\" : \"AU\",\n" +
            "    \"clicks\" : \"27\",\n" +
            "    \"impressions\" : \"313\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"AT\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.04\",\n" +
            "    \"country\" : \"AM\",\n" +
            "    \"clicks\" : \"11\",\n" +
            "    \"impressions\" : \"73\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.07\",\n" +
            "    \"country\" : \"BT\",\n" +
            "    \"clicks\" : \"13\",\n" +
            "    \"impressions\" : \"59\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.03\",\n" +
            "    \"country\" : \"BO\",\n" +
            "    \"clicks\" : \"5\",\n" +
            "    \"impressions\" : \"33\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.02\",\n" +
            "    \"country\" : \"BJ\",\n" +
            "    \"clicks\" : \"5\",\n" +
            "    \"impressions\" : \"35\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"BE\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.04\",\n" +
            "    \"country\" : \"BZ\",\n" +
            "    \"clicks\" : \"3\",\n" +
            "    \"impressions\" : \"18\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"BB\",\n" +
            "    \"clicks\" : \"3\",\n" +
            "    \"impressions\" : \"13\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.16\",\n" +
            "    \"country\" : \"BY\",\n" +
            "    \"clicks\" : \"13\",\n" +
            "    \"impressions\" : \"96\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"BF\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.09\",\n" +
            "    \"country\" : \"BN\",\n" +
            "    \"clicks\" : \"19\",\n" +
            "    \"impressions\" : \"95\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.06\",\n" +
            "    \"country\" : \"BG\",\n" +
            "    \"clicks\" : \"17\",\n" +
            "    \"impressions\" : \"142\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"69.53\",\n" +
            "    \"country\" : \"BR\",\n" +
            "    \"clicks\" : \"1654\",\n" +
            "    \"impressions\" : \"18476\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"BA\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"BW\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"10\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.27\",\n" +
            "    \"country\" : \"CL\",\n" +
            "    \"clicks\" : \"94\",\n" +
            "    \"impressions\" : \"748\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"CF\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"14.91\",\n" +
            "    \"country\" : \"CA\",\n" +
            "    \"clicks\" : \"312\",\n" +
            "    \"impressions\" : \"3961\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"CV\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"8\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"KH\",\n" +
            "    \"clicks\" : \"2\",\n" +
            "    \"impressions\" : \"17\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.23\",\n" +
            "    \"country\" : \"CM\",\n" +
            "    \"clicks\" : \"8\",\n" +
            "    \"impressions\" : \"46\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.04\",\n" +
            "    \"country\" : \"CR\",\n" +
            "    \"clicks\" : \"8\",\n" +
            "    \"impressions\" : \"56\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.31\",\n" +
            "    \"country\" : \"CI\",\n" +
            "    \"clicks\" : \"13\",\n" +
            "    \"impressions\" : \"104\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.10\",\n" +
            "    \"country\" : \"CD\",\n" +
            "    \"clicks\" : \"7\",\n" +
            "    \"impressions\" : \"22\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"8.20\",\n" +
            "    \"country\" : \"CN\",\n" +
            "    \"clicks\" : \"266\",\n" +
            "    \"impressions\" : \"1184\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"CO\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"DM\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.23\",\n" +
            "    \"country\" : \"DO\",\n" +
            "    \"clicks\" : \"31\",\n" +
            "    \"impressions\" : \"224\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.13\",\n" +
            "    \"country\" : \"DK\",\n" +
            "    \"clicks\" : \"10\",\n" +
            "    \"impressions\" : \"83\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"DJ\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"13\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.10\",\n" +
            "    \"country\" : \"CY\",\n" +
            "    \"clicks\" : \"48\",\n" +
            "    \"impressions\" : \"488\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.07\",\n" +
            "    \"country\" : \"CZ\",\n" +
            "    \"clicks\" : \"4\",\n" +
            "    \"impressions\" : \"43\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"HR\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"30\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"CU\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.08\",\n" +
            "    \"country\" : \"ET\",\n" +
            "    \"clicks\" : \"6\",\n" +
            "    \"impressions\" : \"22\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"EE\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.09\",\n" +
            "    \"country\" : \"SV\",\n" +
            "    \"clicks\" : \"14\",\n" +
            "    \"impressions\" : \"70\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"GQ\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"4\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.49\",\n" +
            "    \"country\" : \"EC\",\n" +
            "    \"clicks\" : \"55\",\n" +
            "    \"impressions\" : \"523\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"1.53\",\n" +
            "    \"country\" : \"EG\",\n" +
            "    \"clicks\" : \"526\",\n" +
            "    \"impressions\" : \"3316\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"GA\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"5\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"GM\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.14\",\n" +
            "    \"country\" : \"FI\",\n" +
            "    \"clicks\" : \"23\",\n" +
            "    \"impressions\" : \"147\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"35.82\",\n" +
            "    \"country\" : \"FR\",\n" +
            "    \"clicks\" : \"387\",\n" +
            "    \"impressions\" : \"4954\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"GP\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"2.08\",\n" +
            "    \"country\" : \"GR\",\n" +
            "    \"clicks\" : \"77\",\n" +
            "    \"impressions\" : \"759\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.45\",\n" +
            "    \"country\" : \"GH\",\n" +
            "    \"clicks\" : \"13\",\n" +
            "    \"impressions\" : \"74\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.03\",\n" +
            "    \"country\" : \"GE\",\n" +
            "    \"clicks\" : \"5\",\n" +
            "    \"impressions\" : \"38\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"45.35\",\n" +
            "    \"country\" : \"DE\",\n" +
            "    \"clicks\" : \"535\",\n" +
            "    \"impressions\" : \"5876\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.04\",\n" +
            "    \"country\" : \"HN\",\n" +
            "    \"clicks\" : \"7\",\n" +
            "    \"impressions\" : \"70\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"GY\",\n" +
            "    \"clicks\" : \"4\",\n" +
            "    \"impressions\" : \"23\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.07\",\n" +
            "    \"country\" : \"HT\",\n" +
            "    \"clicks\" : \"10\",\n" +
            "    \"impressions\" : \"102\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"GN\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"GW\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"GU\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.07\",\n" +
            "    \"country\" : \"GT\",\n" +
            "    \"clicks\" : \"12\",\n" +
            "    \"impressions\" : \"96\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"1.31\",\n" +
            "    \"country\" : \"IQ\",\n" +
            "    \"clicks\" : \"57\",\n" +
            "    \"impressions\" : \"255\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"IE\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.25\",\n" +
            "    \"country\" : \"ID\",\n" +
            "    \"clicks\" : \"73\",\n" +
            "    \"impressions\" : \"750\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"IR\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"IS\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"12\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"98.51\",\n" +
            "    \"country\" : \"IN\",\n" +
            "    \"clicks\" : \"2910\",\n" +
            "    \"impressions\" : \"27907\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"3.81\",\n" +
            "    \"country\" : \"HK\",\n" +
            "    \"clicks\" : \"74\",\n" +
            "    \"impressions\" : \"596\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.09\",\n" +
            "    \"country\" : \"HU\",\n" +
            "    \"clicks\" : \"17\",\n" +
            "    \"impressions\" : \"90\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.05\",\n" +
            "    \"country\" : \"KE\",\n" +
            "    \"clicks\" : \"5\",\n" +
            "    \"impressions\" : \"32\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"1.01\",\n" +
            "    \"country\" : \"JO\",\n" +
            "    \"clicks\" : \"75\",\n" +
            "    \"impressions\" : \"656\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.18\",\n" +
            "    \"country\" : \"KZ\",\n" +
            "    \"clicks\" : \"10\",\n" +
            "    \"impressions\" : \"90\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.06\",\n" +
            "    \"country\" : \"JM\",\n" +
            "    \"clicks\" : \"11\",\n" +
            "    \"impressions\" : \"77\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"1.27\",\n" +
            "    \"country\" : \"JP\",\n" +
            "    \"clicks\" : \"46\",\n" +
            "    \"impressions\" : \"475\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.29\",\n" +
            "    \"country\" : \"IL\",\n" +
            "    \"clicks\" : \"56\",\n" +
            "    \"impressions\" : \"409\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"52.89\",\n" +
            "    \"country\" : \"IT\",\n" +
            "    \"clicks\" : \"680\",\n" +
            "    \"impressions\" : \"8912\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"LS\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"4\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"LR\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"LV\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"29\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.86\",\n" +
            "    \"country\" : \"LB\",\n" +
            "    \"clicks\" : \"150\",\n" +
            "    \"impressions\" : \"1181\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.25\",\n" +
            "    \"country\" : \"KG\",\n" +
            "    \"clicks\" : \"67\",\n" +
            "    \"impressions\" : \"281\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"LA\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"17\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"14.19\",\n" +
            "    \"country\" : \"KW\",\n" +
            "    \"clicks\" : \"1716\",\n" +
            "    \"impressions\" : \"26749\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"MW\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"4\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"MO\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"14\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"MK\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"5\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.20\",\n" +
            "    \"country\" : \"LT\",\n" +
            "    \"clicks\" : \"5\",\n" +
            "    \"impressions\" : \"48\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.71\",\n" +
            "    \"country\" : \"LU\",\n" +
            "    \"clicks\" : \"20\",\n" +
            "    \"impressions\" : \"162\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.26\",\n" +
            "    \"country\" : \"LY\",\n" +
            "    \"clicks\" : \"77\",\n" +
            "    \"impressions\" : \"298\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.10\",\n" +
            "    \"country\" : \"MU\",\n" +
            "    \"clicks\" : \"9\",\n" +
            "    \"impressions\" : \"90\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.04\",\n" +
            "    \"country\" : \"ML\",\n" +
            "    \"clicks\" : \"9\",\n" +
            "    \"impressions\" : \"35\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"MT\",\n" +
            "    \"clicks\" : \"4\",\n" +
            "    \"impressions\" : \"66\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"5.13\",\n" +
            "    \"country\" : \"MY\",\n" +
            "    \"clicks\" : \"646\",\n" +
            "    \"impressions\" : \"7172\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"MV\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"14\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.82\",\n" +
            "    \"country\" : \"MA\",\n" +
            "    \"clicks\" : \"56\",\n" +
            "    \"impressions\" : \"496\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.03\",\n" +
            "    \"country\" : \"MN\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"MD\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.52\",\n" +
            "    \"country\" : \"MX\",\n" +
            "    \"clicks\" : \"152\",\n" +
            "    \"impressions\" : \"709\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.69\",\n" +
            "    \"country\" : \"NP\",\n" +
            "    \"clicks\" : \"35\",\n" +
            "    \"impressions\" : \"220\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"NL\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"NA\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"5\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.02\",\n" +
            "    \"country\" : \"MZ\",\n" +
            "    \"clicks\" : \"7\",\n" +
            "    \"impressions\" : \"38\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"MM\",\n" +
            "    \"clicks\" : \"2\",\n" +
            "    \"impressions\" : \"7\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.46\",\n" +
            "    \"country\" : \"NO\",\n" +
            "    \"clicks\" : \"27\",\n" +
            "    \"impressions\" : \"373\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.20\",\n" +
            "    \"country\" : \"OM\",\n" +
            "    \"clicks\" : \"56\",\n" +
            "    \"impressions\" : \"520\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"MP\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.29\",\n" +
            "    \"country\" : \"NG\",\n" +
            "    \"clicks\" : \"31\",\n" +
            "    \"impressions\" : \"207\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"4.26\",\n" +
            "    \"country\" : \"NZ\",\n" +
            "    \"clicks\" : \"24\",\n" +
            "    \"impressions\" : \"172\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"NI\",\n" +
            "    \"clicks\" : \"2\",\n" +
            "    \"impressions\" : \"12\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"1.10\",\n" +
            "    \"country\" : \"PE\",\n" +
            "    \"clicks\" : \"87\",\n" +
            "    \"impressions\" : \"805\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"1.84\",\n" +
            "    \"country\" : \"PH\",\n" +
            "    \"clicks\" : \"176\",\n" +
            "    \"impressions\" : \"1292\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.04\",\n" +
            "    \"country\" : \"PY\",\n" +
            "    \"clicks\" : \"5\",\n" +
            "    \"impressions\" : \"13\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.05\",\n" +
            "    \"country\" : \"PS\",\n" +
            "    \"clicks\" : \"7\",\n" +
            "    \"impressions\" : \"28\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.04\",\n" +
            "    \"country\" : \"PA\",\n" +
            "    \"clicks\" : \"7\",\n" +
            "    \"impressions\" : \"48\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"2.77\",\n" +
            "    \"country\" : \"PK\",\n" +
            "    \"clicks\" : \"315\",\n" +
            "    \"impressions\" : \"3061\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"2.77\",\n" +
            "    \"country\" : \"RU\",\n" +
            "    \"clicks\" : \"239\",\n" +
            "    \"impressions\" : \"1916\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"RW\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"5\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"1.87\",\n" +
            "    \"country\" : \"RO\",\n" +
            "    \"clicks\" : \"63\",\n" +
            "    \"impressions\" : \"477\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.07\",\n" +
            "    \"country\" : \"PR\",\n" +
            "    \"clicks\" : \"8\",\n" +
            "    \"impressions\" : \"86\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"7.65\",\n" +
            "    \"country\" : \"QA\",\n" +
            "    \"clicks\" : \"828\",\n" +
            "    \"impressions\" : \"9634\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.13\",\n" +
            "    \"country\" : \"PL\",\n" +
            "    \"clicks\" : \"12\",\n" +
            "    \"impressions\" : \"82\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.29\",\n" +
            "    \"country\" : \"PT\",\n" +
            "    \"clicks\" : \"21\",\n" +
            "    \"impressions\" : \"175\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.05\",\n" +
            "    \"country\" : \"SC\",\n" +
            "    \"clicks\" : \"8\",\n" +
            "    \"impressions\" : \"22\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"SL\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.07\",\n" +
            "    \"country\" : \"SN\",\n" +
            "    \"clicks\" : \"5\",\n" +
            "    \"impressions\" : \"47\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"RS\",\n" +
            "    \"clicks\" : \"2\",\n" +
            "    \"impressions\" : \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"22.76\",\n" +
            "    \"country\" : \"SA\",\n" +
            "    \"clicks\" : \"3398\",\n" +
            "    \"impressions\" : \"52029\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"2.59\",\n" +
            "    \"country\" : \"KR\",\n" +
            "    \"clicks\" : \"216\",\n" +
            "    \"impressions\" : \"1761\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"13.43\",\n" +
            "    \"country\" : \"ES\",\n" +
            "    \"clicks\" : \"379\",\n" +
            "    \"impressions\" : \"2993\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"SO\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"3.05\",\n" +
            "    \"country\" : \"ZA\",\n" +
            "    \"clicks\" : \"32\",\n" +
            "    \"impressions\" : \"248\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"SI\",\n" +
            "    \"clicks\" : \"2\",\n" +
            "    \"impressions\" : \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"5.81\",\n" +
            "    \"country\" : \"SG\",\n" +
            "    \"clicks\" : \"300\",\n" +
            "    \"impressions\" : \"3038\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"SK\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"8\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"SD\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"SR\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"VC\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"KN\",\n" +
            "    \"clicks\" : \"2\",\n" +
            "    \"impressions\" : \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"LC\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.09\",\n" +
            "    \"country\" : \"LK\",\n" +
            "    \"clicks\" : \"11\",\n" +
            "    \"impressions\" : \"80\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.03\",\n" +
            "    \"country\" : \"TZ\",\n" +
            "    \"clicks\" : \"2\",\n" +
            "    \"impressions\" : \"31\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.48\",\n" +
            "    \"country\" : \"TH\",\n" +
            "    \"clicks\" : \"40\",\n" +
            "    \"impressions\" : \"380\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"16.24\",\n" +
            "    \"country\" : \"TW\",\n" +
            "    \"clicks\" : \"383\",\n" +
            "    \"impressions\" : \"3842\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"TJ\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"3.88\",\n" +
            "    \"country\" : \"CH\",\n" +
            "    \"clicks\" : \"55\",\n" +
            "    \"impressions\" : \"567\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"SY\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"SZ\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"2.93\",\n" +
            "    \"country\" : \"SE\",\n" +
            "    \"clicks\" : \"126\",\n" +
            "    \"impressions\" : \"1590\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"2.88\",\n" +
            "    \"country\" : \"TR\",\n" +
            "    \"clicks\" : \"646\",\n" +
            "    \"impressions\" : \"4921\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"TT\",\n" +
            "    \"clicks\" : \"5\",\n" +
            "    \"impressions\" : \"48\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.03\",\n" +
            "    \"country\" : \"TN\",\n" +
            "    \"clicks\" : \"13\",\n" +
            "    \"impressions\" : \"46\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.01\",\n" +
            "    \"country\" : \"TG\",\n" +
            "    \"clicks\" : \"1\",\n" +
            "    \"impressions\" : \"7\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.15\",\n" +
            "    \"country\" : \"UY\",\n" +
            "    \"clicks\" : \"5\",\n" +
            "    \"impressions\" : \"30\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"VI\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"16.43\",\n" +
            "    \"country\" : \"AE\",\n" +
            "    \"clicks\" : \"1006\",\n" +
            "    \"impressions\" : \"10616\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"54.19\",\n" +
            "    \"country\" : \"GB\",\n" +
            "    \"clicks\" : \"637\",\n" +
            "    \"impressions\" : \"6803\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.02\",\n" +
            "    \"country\" : \"UG\",\n" +
            "    \"clicks\" : \"4\",\n" +
            "    \"impressions\" : \"22\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"2.29\",\n" +
            "    \"country\" : \"UA\",\n" +
            "    \"clicks\" : \"58\",\n" +
            "    \"impressions\" : \"299\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"TC\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.05\",\n" +
            "    \"country\" : \"ZM\",\n" +
            "    \"clicks\" : \"7\",\n" +
            "    \"impressions\" : \"39\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.02\",\n" +
            "    \"country\" : \"ZW\",\n" +
            "    \"clicks\" : \"4\",\n" +
            "    \"impressions\" : \"44\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.04\",\n" +
            "    \"country\" : \"YE\",\n" +
            "    \"clicks\" : \"4\",\n" +
            "    \"impressions\" : \"22\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.29\",\n" +
            "    \"country\" : \"VE\",\n" +
            "    \"clicks\" : \"42\",\n" +
            "    \"impressions\" : \"299\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"VN\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"0\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"installs\" : \"0\",\n" +
            "    \"completions\" : \"0\",\n" +
            "    \"revenue\" : \"0.00\",\n" +
            "    \"country\" : \"UZ\",\n" +
            "    \"clicks\" : \"0\",\n" +
            "    \"impressions\" : \"4\"\n" +
            "  }\n" +
            "]";

    private static String JasonString = "{\"@generatedDate\":\"1/9/17 4:36 AM\",\"@version\":\"1.0\",\"currency\":\"usd\",\"results\":{\"country_stats\":[{\"clicks\":\"3\",\"completions\":\"0\",\"impressions\":\"30\",\"installs\":\"0\",\"revenue\":\"0.03\",\"country\":\"Unknown\"},{\"clicks\":\"3700\",\"completions\":\"0\",\"impressions\":\"134684\",\"installs\":\"0\",\"revenue\":\"204.33\",\"country\":\"US\"},{\"clicks\":\"27\",\"completions\":\"0\",\"impressions\":\"88\",\"installs\":\"0\",\"revenue\":\"0.09\",\"country\":\"AF\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"2\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"AG\"},{\"clicks\":\"38\",\"completions\":\"0\",\"impressions\":\"436\",\"installs\":\"0\",\"revenue\":\"0.95\",\"country\":\"AR\"},{\"clicks\":\"4\",\"completions\":\"0\",\"impressions\":\"19\",\"installs\":\"0\",\"revenue\":\"0.11\",\"country\":\"AO\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"3\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"AI\"},{\"clicks\":\"2\",\"completions\":\"0\",\"impressions\":\"2\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"AS\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"8\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"AD\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"68\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"AL\"},{\"clicks\":\"19\",\"completions\":\"0\",\"impressions\":\"161\",\"installs\":\"0\",\"revenue\":\"0.15\",\"country\":\"DZ\"},{\"clicks\":\"204\",\"completions\":\"0\",\"impressions\":\"1783\",\"installs\":\"0\",\"revenue\":\"1.54\",\"country\":\"BH\"},{\"clicks\":\"612\",\"completions\":\"0\",\"impressions\":\"4399\",\"installs\":\"0\",\"revenue\":\"6.40\",\"country\":\"BD\"},{\"clicks\":\"5\",\"completions\":\"0\",\"impressions\":\"32\",\"installs\":\"0\",\"revenue\":\"0.08\",\"country\":\"AZ\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"28\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"BS\"},{\"clicks\":\"27\",\"completions\":\"0\",\"impressions\":\"313\",\"installs\":\"0\",\"revenue\":\"2.65\",\"country\":\"AU\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"AT\"},{\"clicks\":\"11\",\"completions\":\"0\",\"impressions\":\"73\",\"installs\":\"0\",\"revenue\":\"0.04\",\"country\":\"AM\"},{\"clicks\":\"13\",\"completions\":\"0\",\"impressions\":\"59\",\"installs\":\"0\",\"revenue\":\"0.07\",\"country\":\"BT\"},{\"clicks\":\"5\",\"completions\":\"0\",\"impressions\":\"33\",\"installs\":\"0\",\"revenue\":\"0.03\",\"country\":\"BO\"},{\"clicks\":\"5\",\"completions\":\"0\",\"impressions\":\"35\",\"installs\":\"0\",\"revenue\":\"0.02\",\"country\":\"BJ\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"BE\"},{\"clicks\":\"3\",\"completions\":\"0\",\"impressions\":\"18\",\"installs\":\"0\",\"revenue\":\"0.04\",\"country\":\"BZ\"},{\"clicks\":\"3\",\"completions\":\"0\",\"impressions\":\"13\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"BB\"},{\"clicks\":\"13\",\"completions\":\"0\",\"impressions\":\"96\",\"installs\":\"0\",\"revenue\":\"0.16\",\"country\":\"BY\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"BF\"},{\"clicks\":\"19\",\"completions\":\"0\",\"impressions\":\"95\",\"installs\":\"0\",\"revenue\":\"0.09\",\"country\":\"BN\"},{\"clicks\":\"17\",\"completions\":\"0\",\"impressions\":\"142\",\"installs\":\"0\",\"revenue\":\"0.06\",\"country\":\"BG\"},{\"clicks\":\"1654\",\"completions\":\"0\",\"impressions\":\"18476\",\"installs\":\"0\",\"revenue\":\"69.53\",\"country\":\"BR\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"BA\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"10\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"BW\"},{\"clicks\":\"94\",\"completions\":\"0\",\"impressions\":\"748\",\"installs\":\"0\",\"revenue\":\"0.27\",\"country\":\"CL\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"CF\"},{\"clicks\":\"312\",\"completions\":\"0\",\"impressions\":\"3961\",\"installs\":\"0\",\"revenue\":\"14.91\",\"country\":\"CA\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"8\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"CV\"},{\"clicks\":\"2\",\"completions\":\"0\",\"impressions\":\"17\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"KH\"},{\"clicks\":\"8\",\"completions\":\"0\",\"impressions\":\"46\",\"installs\":\"0\",\"revenue\":\"0.23\",\"country\":\"CM\"},{\"clicks\":\"8\",\"completions\":\"0\",\"impressions\":\"56\",\"installs\":\"0\",\"revenue\":\"0.04\",\"country\":\"CR\"},{\"clicks\":\"13\",\"completions\":\"0\",\"impressions\":\"104\",\"installs\":\"0\",\"revenue\":\"0.31\",\"country\":\"CI\"},{\"clicks\":\"7\",\"completions\":\"0\",\"impressions\":\"22\",\"installs\":\"0\",\"revenue\":\"0.10\",\"country\":\"CD\"},{\"clicks\":\"266\",\"completions\":\"0\",\"impressions\":\"1184\",\"installs\":\"0\",\"revenue\":\"8.20\",\"country\":\"CN\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"CO\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"2\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"DM\"},{\"clicks\":\"31\",\"completions\":\"0\",\"impressions\":\"224\",\"installs\":\"0\",\"revenue\":\"0.23\",\"country\":\"DO\"},{\"clicks\":\"10\",\"completions\":\"0\",\"impressions\":\"83\",\"installs\":\"0\",\"revenue\":\"0.13\",\"country\":\"DK\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"13\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"DJ\"},{\"clicks\":\"48\",\"completions\":\"0\",\"impressions\":\"488\",\"installs\":\"0\",\"revenue\":\"0.10\",\"country\":\"CY\"},{\"clicks\":\"4\",\"completions\":\"0\",\"impressions\":\"43\",\"installs\":\"0\",\"revenue\":\"0.07\",\"country\":\"CZ\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"30\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"HR\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"CU\"},{\"clicks\":\"6\",\"completions\":\"0\",\"impressions\":\"22\",\"installs\":\"0\",\"revenue\":\"0.08\",\"country\":\"ET\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"3\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"EE\"},{\"clicks\":\"14\",\"completions\":\"0\",\"impressions\":\"70\",\"installs\":\"0\",\"revenue\":\"0.09\",\"country\":\"SV\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"4\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"GQ\"},{\"clicks\":\"55\",\"completions\":\"0\",\"impressions\":\"523\",\"installs\":\"0\",\"revenue\":\"0.49\",\"country\":\"EC\"},{\"clicks\":\"526\",\"completions\":\"0\",\"impressions\":\"3316\",\"installs\":\"0\",\"revenue\":\"1.53\",\"country\":\"EG\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"5\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"GA\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"GM\"},{\"clicks\":\"23\",\"completions\":\"0\",\"impressions\":\"147\",\"installs\":\"0\",\"revenue\":\"0.14\",\"country\":\"FI\"},{\"clicks\":\"387\",\"completions\":\"0\",\"impressions\":\"4954\",\"installs\":\"0\",\"revenue\":\"35.82\",\"country\":\"FR\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"GP\"},{\"clicks\":\"77\",\"completions\":\"0\",\"impressions\":\"759\",\"installs\":\"0\",\"revenue\":\"2.08\",\"country\":\"GR\"},{\"clicks\":\"13\",\"completions\":\"0\",\"impressions\":\"74\",\"installs\":\"0\",\"revenue\":\"0.45\",\"country\":\"GH\"},{\"clicks\":\"5\",\"completions\":\"0\",\"impressions\":\"38\",\"installs\":\"0\",\"revenue\":\"0.03\",\"country\":\"GE\"},{\"clicks\":\"535\",\"completions\":\"0\",\"impressions\":\"5876\",\"installs\":\"0\",\"revenue\":\"45.35\",\"country\":\"DE\"},{\"clicks\":\"7\",\"completions\":\"0\",\"impressions\":\"70\",\"installs\":\"0\",\"revenue\":\"0.04\",\"country\":\"HN\"},{\"clicks\":\"4\",\"completions\":\"0\",\"impressions\":\"23\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"GY\"},{\"clicks\":\"10\",\"completions\":\"0\",\"impressions\":\"102\",\"installs\":\"0\",\"revenue\":\"0.07\",\"country\":\"HT\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"3\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"GN\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"GW\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"1\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"GU\"},{\"clicks\":\"12\",\"completions\":\"0\",\"impressions\":\"96\",\"installs\":\"0\",\"revenue\":\"0.07\",\"country\":\"GT\"},{\"clicks\":\"57\",\"completions\":\"0\",\"impressions\":\"255\",\"installs\":\"0\",\"revenue\":\"1.31\",\"country\":\"IQ\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"IE\"},{\"clicks\":\"73\",\"completions\":\"0\",\"impressions\":\"750\",\"installs\":\"0\",\"revenue\":\"0.25\",\"country\":\"ID\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"IR\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"12\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"IS\"},{\"clicks\":\"2910\",\"completions\":\"0\",\"impressions\":\"27907\",\"installs\":\"0\",\"revenue\":\"98.51\",\"country\":\"IN\"},{\"clicks\":\"74\",\"completions\":\"0\",\"impressions\":\"596\",\"installs\":\"0\",\"revenue\":\"3.81\",\"country\":\"HK\"},{\"clicks\":\"17\",\"completions\":\"0\",\"impressions\":\"90\",\"installs\":\"0\",\"revenue\":\"0.09\",\"country\":\"HU\"},{\"clicks\":\"5\",\"completions\":\"0\",\"impressions\":\"32\",\"installs\":\"0\",\"revenue\":\"0.05\",\"country\":\"KE\"},{\"clicks\":\"75\",\"completions\":\"0\",\"impressions\":\"656\",\"installs\":\"0\",\"revenue\":\"1.01\",\"country\":\"JO\"},{\"clicks\":\"10\",\"completions\":\"0\",\"impressions\":\"90\",\"installs\":\"0\",\"revenue\":\"0.18\",\"country\":\"KZ\"},{\"clicks\":\"11\",\"completions\":\"0\",\"impressions\":\"77\",\"installs\":\"0\",\"revenue\":\"0.06\",\"country\":\"JM\"},{\"clicks\":\"46\",\"completions\":\"0\",\"impressions\":\"475\",\"installs\":\"0\",\"revenue\":\"1.27\",\"country\":\"JP\"},{\"clicks\":\"56\",\"completions\":\"0\",\"impressions\":\"409\",\"installs\":\"0\",\"revenue\":\"0.29\",\"country\":\"IL\"},{\"clicks\":\"680\",\"completions\":\"0\",\"impressions\":\"8912\",\"installs\":\"0\",\"revenue\":\"52.89\",\"country\":\"IT\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"4\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"LS\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"LR\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"29\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"LV\"},{\"clicks\":\"150\",\"completions\":\"0\",\"impressions\":\"1181\",\"installs\":\"0\",\"revenue\":\"0.86\",\"country\":\"LB\"},{\"clicks\":\"67\",\"completions\":\"0\",\"impressions\":\"281\",\"installs\":\"0\",\"revenue\":\"0.25\",\"country\":\"KG\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"17\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"LA\"},{\"clicks\":\"1716\",\"completions\":\"0\",\"impressions\":\"26749\",\"installs\":\"0\",\"revenue\":\"14.19\",\"country\":\"KW\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"4\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"MW\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"14\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"MO\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"5\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"MK\"},{\"clicks\":\"5\",\"completions\":\"0\",\"impressions\":\"48\",\"installs\":\"0\",\"revenue\":\"0.20\",\"country\":\"LT\"},{\"clicks\":\"20\",\"completions\":\"0\",\"impressions\":\"162\",\"installs\":\"0\",\"revenue\":\"0.71\",\"country\":\"LU\"},{\"clicks\":\"77\",\"completions\":\"0\",\"impressions\":\"298\",\"installs\":\"0\",\"revenue\":\"0.26\",\"country\":\"LY\"},{\"clicks\":\"9\",\"completions\":\"0\",\"impressions\":\"90\",\"installs\":\"0\",\"revenue\":\"0.10\",\"country\":\"MU\"},{\"clicks\":\"9\",\"completions\":\"0\",\"impressions\":\"35\",\"installs\":\"0\",\"revenue\":\"0.04\",\"country\":\"ML\"},{\"clicks\":\"4\",\"completions\":\"0\",\"impressions\":\"66\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"MT\"},{\"clicks\":\"646\",\"completions\":\"0\",\"impressions\":\"7172\",\"installs\":\"0\",\"revenue\":\"5.13\",\"country\":\"MY\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"14\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"MV\"},{\"clicks\":\"56\",\"completions\":\"0\",\"impressions\":\"496\",\"installs\":\"0\",\"revenue\":\"0.82\",\"country\":\"MA\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"1\",\"installs\":\"0\",\"revenue\":\"0.03\",\"country\":\"MN\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"1\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"MD\"},{\"clicks\":\"152\",\"completions\":\"0\",\"impressions\":\"709\",\"installs\":\"0\",\"revenue\":\"0.52\",\"country\":\"MX\"},{\"clicks\":\"35\",\"completions\":\"0\",\"impressions\":\"220\",\"installs\":\"0\",\"revenue\":\"0.69\",\"country\":\"NP\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"NL\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"5\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"NA\"},{\"clicks\":\"7\",\"completions\":\"0\",\"impressions\":\"38\",\"installs\":\"0\",\"revenue\":\"0.02\",\"country\":\"MZ\"},{\"clicks\":\"2\",\"completions\":\"0\",\"impressions\":\"7\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"MM\"},{\"clicks\":\"27\",\"completions\":\"0\",\"impressions\":\"373\",\"installs\":\"0\",\"revenue\":\"0.46\",\"country\":\"NO\"},{\"clicks\":\"56\",\"completions\":\"0\",\"impressions\":\"520\",\"installs\":\"0\",\"revenue\":\"0.20\",\"country\":\"OM\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"1\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"MP\"},{\"clicks\":\"31\",\"completions\":\"0\",\"impressions\":\"207\",\"installs\":\"0\",\"revenue\":\"0.29\",\"country\":\"NG\"},{\"clicks\":\"24\",\"completions\":\"0\",\"impressions\":\"172\",\"installs\":\"0\",\"revenue\":\"4.26\",\"country\":\"NZ\"},{\"clicks\":\"2\",\"completions\":\"0\",\"impressions\":\"12\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"NI\"},{\"clicks\":\"87\",\"completions\":\"0\",\"impressions\":\"805\",\"installs\":\"0\",\"revenue\":\"1.10\",\"country\":\"PE\"},{\"clicks\":\"176\",\"completions\":\"0\",\"impressions\":\"1292\",\"installs\":\"0\",\"revenue\":\"1.84\",\"country\":\"PH\"},{\"clicks\":\"5\",\"completions\":\"0\",\"impressions\":\"13\",\"installs\":\"0\",\"revenue\":\"0.04\",\"country\":\"PY\"},{\"clicks\":\"7\",\"completions\":\"0\",\"impressions\":\"28\",\"installs\":\"0\",\"revenue\":\"0.05\",\"country\":\"PS\"},{\"clicks\":\"7\",\"completions\":\"0\",\"impressions\":\"48\",\"installs\":\"0\",\"revenue\":\"0.04\",\"country\":\"PA\"},{\"clicks\":\"315\",\"completions\":\"0\",\"impressions\":\"3061\",\"installs\":\"0\",\"revenue\":\"2.77\",\"country\":\"PK\"},{\"clicks\":\"239\",\"completions\":\"0\",\"impressions\":\"1916\",\"installs\":\"0\",\"revenue\":\"2.77\",\"country\":\"RU\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"5\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"RW\"},{\"clicks\":\"63\",\"completions\":\"0\",\"impressions\":\"477\",\"installs\":\"0\",\"revenue\":\"1.87\",\"country\":\"RO\"},{\"clicks\":\"8\",\"completions\":\"0\",\"impressions\":\"86\",\"installs\":\"0\",\"revenue\":\"0.07\",\"country\":\"PR\"},{\"clicks\":\"828\",\"completions\":\"0\",\"impressions\":\"9634\",\"installs\":\"0\",\"revenue\":\"7.65\",\"country\":\"QA\"},{\"clicks\":\"12\",\"completions\":\"0\",\"impressions\":\"82\",\"installs\":\"0\",\"revenue\":\"0.13\",\"country\":\"PL\"},{\"clicks\":\"21\",\"completions\":\"0\",\"impressions\":\"175\",\"installs\":\"0\",\"revenue\":\"0.29\",\"country\":\"PT\"},{\"clicks\":\"8\",\"completions\":\"0\",\"impressions\":\"22\",\"installs\":\"0\",\"revenue\":\"0.05\",\"country\":\"SC\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"1\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"SL\"},{\"clicks\":\"5\",\"completions\":\"0\",\"impressions\":\"47\",\"installs\":\"0\",\"revenue\":\"0.07\",\"country\":\"SN\"},{\"clicks\":\"2\",\"completions\":\"0\",\"impressions\":\"2\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"RS\"},{\"clicks\":\"3398\",\"completions\":\"0\",\"impressions\":\"52029\",\"installs\":\"0\",\"revenue\":\"22.76\",\"country\":\"SA\"},{\"clicks\":\"216\",\"completions\":\"0\",\"impressions\":\"1761\",\"installs\":\"0\",\"revenue\":\"2.59\",\"country\":\"KR\"},{\"clicks\":\"379\",\"completions\":\"0\",\"impressions\":\"2993\",\"installs\":\"0\",\"revenue\":\"13.43\",\"country\":\"ES\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"SO\"},{\"clicks\":\"32\",\"completions\":\"0\",\"impressions\":\"248\",\"installs\":\"0\",\"revenue\":\"3.05\",\"country\":\"ZA\"},{\"clicks\":\"2\",\"completions\":\"0\",\"impressions\":\"2\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"SI\"},{\"clicks\":\"300\",\"completions\":\"0\",\"impressions\":\"3038\",\"installs\":\"0\",\"revenue\":\"5.81\",\"country\":\"SG\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"8\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"SK\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"SD\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"1\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"SR\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"1\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"VC\"},{\"clicks\":\"2\",\"completions\":\"0\",\"impressions\":\"2\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"KN\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"1\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"LC\"},{\"clicks\":\"11\",\"completions\":\"0\",\"impressions\":\"80\",\"installs\":\"0\",\"revenue\":\"0.09\",\"country\":\"LK\"},{\"clicks\":\"2\",\"completions\":\"0\",\"impressions\":\"31\",\"installs\":\"0\",\"revenue\":\"0.03\",\"country\":\"TZ\"},{\"clicks\":\"40\",\"completions\":\"0\",\"impressions\":\"380\",\"installs\":\"0\",\"revenue\":\"0.48\",\"country\":\"TH\"},{\"clicks\":\"383\",\"completions\":\"0\",\"impressions\":\"3842\",\"installs\":\"0\",\"revenue\":\"16.24\",\"country\":\"TW\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"1\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"TJ\"},{\"clicks\":\"55\",\"completions\":\"0\",\"impressions\":\"567\",\"installs\":\"0\",\"revenue\":\"3.88\",\"country\":\"CH\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"SY\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"SZ\"},{\"clicks\":\"126\",\"completions\":\"0\",\"impressions\":\"1590\",\"installs\":\"0\",\"revenue\":\"2.93\",\"country\":\"SE\"},{\"clicks\":\"646\",\"completions\":\"0\",\"impressions\":\"4921\",\"installs\":\"0\",\"revenue\":\"2.88\",\"country\":\"TR\"},{\"clicks\":\"5\",\"completions\":\"0\",\"impressions\":\"48\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"TT\"},{\"clicks\":\"13\",\"completions\":\"0\",\"impressions\":\"46\",\"installs\":\"0\",\"revenue\":\"0.03\",\"country\":\"TN\"},{\"clicks\":\"1\",\"completions\":\"0\",\"impressions\":\"7\",\"installs\":\"0\",\"revenue\":\"0.01\",\"country\":\"TG\"},{\"clicks\":\"5\",\"completions\":\"0\",\"impressions\":\"30\",\"installs\":\"0\",\"revenue\":\"0.15\",\"country\":\"UY\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"2\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"VI\"},{\"clicks\":\"1006\",\"completions\":\"0\",\"impressions\":\"10616\",\"installs\":\"0\",\"revenue\":\"16.43\",\"country\":\"AE\"},{\"clicks\":\"637\",\"completions\":\"0\",\"impressions\":\"6803\",\"installs\":\"0\",\"revenue\":\"54.19\",\"country\":\"GB\"},{\"clicks\":\"4\",\"completions\":\"0\",\"impressions\":\"22\",\"installs\":\"0\",\"revenue\":\"0.02\",\"country\":\"UG\"},{\"clicks\":\"58\",\"completions\":\"0\",\"impressions\":\"299\",\"installs\":\"0\",\"revenue\":\"2.29\",\"country\":\"UA\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"TC\"},{\"clicks\":\"7\",\"completions\":\"0\",\"impressions\":\"39\",\"installs\":\"0\",\"revenue\":\"0.05\",\"country\":\"ZM\"},{\"clicks\":\"4\",\"completions\":\"0\",\"impressions\":\"44\",\"installs\":\"0\",\"revenue\":\"0.02\",\"country\":\"ZW\"},{\"clicks\":\"4\",\"completions\":\"0\",\"impressions\":\"22\",\"installs\":\"0\",\"revenue\":\"0.04\",\"country\":\"YE\"},{\"clicks\":\"42\",\"completions\":\"0\",\"impressions\":\"299\",\"installs\":\"0\",\"revenue\":\"0.29\",\"country\":\"VE\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"0\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"VN\"},{\"clicks\":\"0\",\"completions\":\"0\",\"impressions\":\"4\",\"installs\":\"0\",\"revenue\":\"0.00\",\"country\":\"UZ\"}],\"global_stats\":{\"clicks\":\"25148\",\"completions\":\"0\",\"impressions\":\"370884\",\"installs\":\"0\",\"revenue\":\"752.55\"},\"date\":\"2016-12-25\"}}";

    public static void main(String [] args) {
        System.out.print("123");

        try {
            JSONObject flurryInfoJsonObject = new JSONObject(JasonString);
//            JSONArray jsonArray = new JSONArray(inputString);
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObject = jsonArray.optJSONObject(i);
//                String country = jsonObject.optString("country");
//                System.out.print(country);
//            }

            JSONObject results = flurryInfoJsonObject.optJSONObject("results");
            JSONArray jsonArray = results.getJSONArray("country_stats");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);
                String country = jsonObject.optString("country");
                System.out.print(country);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}
