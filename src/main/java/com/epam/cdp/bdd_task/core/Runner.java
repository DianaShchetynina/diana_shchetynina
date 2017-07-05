package com.epam.cdp.bdd_task.core;

import com.epam.cdp.bdd_task.steps.SendMessageTestSteps;
import com.epam.cdp.bdd_task.util.Properties;
import com.epam.cdp.bdd_task.util.PropertiesReader;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.ArrayList;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;


public class Runner extends JUnitStories {
    public Runner() {
        configuredEmbedder().embedderControls()
                .doGenerateViewAfterStories(true)
                .doIgnoreFailureInStories(true)
                .doIgnoreFailureInView(true).useStoryTimeoutInSecs(60);
    }

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(embeddableClass))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                        .withDefaultFormats()
                        .withFormats(CONSOLE, HTML));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new SendMessageTestSteps());
    }

    @Override
    protected List<String> storyPaths() {
        List<String> storiesToRun = new ArrayList<String>();
        String storyProperty = System.getProperty("story");

        if (storyProperty == null || storyProperty.isEmpty()) {
            Properties.properties = PropertiesReader.getProperty();
            storyProperty = Properties.getDefaultStory();
        }
        String[] storyNames = storyProperty.split(",");
        StoryFinder sf = new StoryFinder();
        for (String storyName : storyNames) {
            storiesToRun.addAll(sf.findPaths(codeLocationFromClass(this.getClass()), "**/" + storyName + ".story", ""));
        }
        return storiesToRun;
    }

}