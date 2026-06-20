package com.gqt.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.util.regex.*;

public class ResumeSummarizer extends JFrame {

    private JTextArea inputArea;
    private JTextArea outputArea;
    private JButton summarizeButton;

    private final String[] skillDatabase = {
            "Java", "Python", "JavaScript",
            "Spring Boot", "React", "Angular",
            "SQL", "MySQL", "PostgreSQL",
            "MongoDB", "AWS", "Azure",
            "Docker", "Kubernetes",
            "Git", "Machine Learning",
            "Data Structures", "REST API"
    };

    public ResumeSummarizer() {

        setTitle("Resume Summarizer");
        setSize(900, 650);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeUI();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel panel = new JPanel(new BorderLayout(10,10));

        JLabel inputLabel = new JLabel("Paste Resume");

        inputArea = new JTextArea();
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);

        JScrollPane inputScroll =
                new JScrollPane(inputArea);

        summarizeButton =
                new JButton("Generate Summary");

        JLabel outputLabel =
                new JLabel("Summary");

        outputArea =
                new JTextArea();

        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        JScrollPane outputScroll =
                new JScrollPane(outputArea);

        JPanel topPanel =
                new JPanel(new BorderLayout());

        topPanel.add(inputLabel,
                BorderLayout.NORTH);

        topPanel.add(inputScroll,
                BorderLayout.CENTER);

        JPanel middlePanel =
                new JPanel();

        middlePanel.add(summarizeButton);

        JPanel bottomPanel =
                new JPanel(new BorderLayout());

        bottomPanel.add(outputLabel,
                BorderLayout.NORTH);

        bottomPanel.add(outputScroll,
                BorderLayout.CENTER);

        panel.add(topPanel,
                BorderLayout.NORTH);

        panel.add(middlePanel,
                BorderLayout.CENTER);

        panel.add(bottomPanel,
                BorderLayout.SOUTH);

        topPanel.setPreferredSize(
                new Dimension(800,250));

        bottomPanel.setPreferredSize(
                new Dimension(800,250));

        add(panel);

        summarizeButton.addActionListener(
                e -> generateSummary()
        );
    }

    private void generateSummary() {

        String resume =
                inputArea.getText();

        if (resume.trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a resume."
            );

            return;
        }

        String name =
                extractName(resume);

        String email =
                extractEmail(resume);

        String experience =
                extractExperience(resume);

        List<String> skills =
                extractSkills(resume);

        StringBuilder summary =
                new StringBuilder();

        summary.append("===== RESUME SUMMARY =====\n\n");

        summary.append("Name: ")
                .append(name)
                .append("\n");

        summary.append("Email: ")
                .append(email)
                .append("\n");

        summary.append("Experience: ")
                .append(experience)
                .append("\n\n");

        summary.append("Skills:\n");

        if(skills.isEmpty()) {

            summary.append("No skills detected");

        } else {

            for(String skill : skills) {

                summary.append("• ")
                        .append(skill)
                        .append("\n");
            }
        }

        summary.append("\n");

        summary.append("Professional Summary:\n");

        summary.append(name)
                .append(" is a candidate with ");

        summary.append(experience)
                .append(" of experience and expertise in ");

        if(skills.isEmpty()) {

            summary.append("multiple technical domains.");

        } else {

            summary.append(
                    String.join(", ", skills)
            );

            summary.append(".");
        }

        outputArea.setText(
                summary.toString()
        );
    }

    private String extractName(String text) {

        String[] lines =
                text.split("\n");

        for(String line : lines) {

            line = line.trim();

            if(line.matches(
                    "^[A-Z][a-z]+\\s[A-Z][a-z]+.*")) {

                return line;
            }
        }

        return "Not Found";
    }

    private String extractEmail(String text) {

        Pattern pattern =
                Pattern.compile(
                        "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+"
                );

        Matcher matcher =
                pattern.matcher(text);

        if(matcher.find()) {

            return matcher.group();
        }

        return "Not Found";
    }

    private String extractExperience(
            String text) {

        Pattern pattern =
                Pattern.compile(
                        "(\\d+)\\+?\\s*(years?|yrs?)",
                        Pattern.CASE_INSENSITIVE
                );

        Matcher matcher =
                pattern.matcher(text);

        if(matcher.find()) {

            return matcher.group();
        }

        return "Experience not specified";
    }

    private List<String> extractSkills(
            String text) {

        List<String> skills =
                new ArrayList<>();

        for(String skill :
                skillDatabase) {

            Pattern pattern =
                    Pattern.compile(
                            "\\b"
                            + Pattern.quote(skill)
                            + "\\b",
                            Pattern.CASE_INSENSITIVE
                    );

            Matcher matcher =
                    pattern.matcher(text);

            if(matcher.find()) {

                skills.add(skill);
            }
        }

        return skills;
    }

    public static void main(
            String[] args) {

        SwingUtilities.invokeLater(
                ResumeSummarizer::new
        );
    }
}
