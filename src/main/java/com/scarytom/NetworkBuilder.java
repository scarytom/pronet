package com.scarytom;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.scarytom.pronet.Programmer;
import nu.xom.*;

public class NetworkBuilder {
	private final Set<Programmer> _programmer = new HashSet<Programmer>();

    public static NetworkBuilder buildNetwork(String filename) throws ParsingException, IOException {
        File file = new File(filename);

        NetworkBuilder networkBuilder = new NetworkBuilder();
        Builder parser = new Builder();
        Document doc = parser.build(file);

        Map<String, Programmer> programmersMap = Maps.newHashMap();

        Element rootElement = doc.getRootElement();
        Elements programmers = rootElement.getChildElements();
        for (int i = 0; i < programmers.size(); i++) {
            Element programmerNode = programmers.get(i);
            String name = programmerNode.getAttribute("name").getValue();
            Elements skillsNode = programmerNode.getChildElements("Skills");
            Elements childElements = skillsNode.get(0).getChildElements();
            Set<String> skills = Sets.newHashSet();
            for (int j=0; j< childElements.size(); j++) {
                String skill = childElements.get(j).getValue();
                skills.add(skill);
            }
            Programmer programmer = new Programmer(name, skills);
            programmersMap.put(name, programmer);
            networkBuilder.withProgrammer(programmer);
        }

        for (int i = 0; i < programmers.size(); i++) {
            Element programmerNode = programmers.get(i);
            String name = programmerNode.getAttribute("name").getValue();
            Elements recommendationsNode = programmerNode.getChildElements("Recommendations");
            Elements childElements = recommendationsNode.get(0).getChildElements();
            for (int j=0; j< childElements.size(); j++) {
                String recommendation = childElements.get(j).getValue();
                programmersMap.get(name).addRecommendation(programmersMap.get(recommendation));
            }
        }
        return networkBuilder;
    }

    public Network build() {
		Network network = new Network(_programmer);
		return network;

	}

	public NetworkBuilder withProgrammer(final Programmer programmer) {
		_programmer.add(programmer);
		return this;
	}
}
