package com.notification.types;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import com.theme.TextTheme;
import com.theme.WindowTheme;

/**
 * A text notification which will display a title and a subtitle.
 */
public class TextNotification extends BorderLayoutNotification {
	private TextTheme m_theme;

	private JLabel m_titleLabel;
	private JLabel m_subtitleLabel;

	public TextNotification() {
		m_titleLabel = new JLabel();
		m_subtitleLabel = new JLabel();

		this.addComponent(m_titleLabel, BorderLayout.NORTH);
		this.addComponent(m_subtitleLabel, BorderLayout.CENTER);
	}

	protected TextTheme getTextTheme() {
		return m_theme;
	}

	/**
	 * @param theme
	 *            the two Fonts that should be used.
	 */
	public void setTextTheme(TextTheme theme) {
		m_theme = theme;
		m_titleLabel.setFont(theme.title);
		m_subtitleLabel.setFont(theme.subtitle);
		m_titleLabel.setForeground(theme.titleColor);
		m_subtitleLabel.setForeground(theme.subtitleColor);
	}

	public String getTitle() {
		return m_titleLabel.getText();
	}

	public void setTitle(String title) {
		m_titleLabel.setText(title);
	}

	public String getSubtitle() {
		return m_subtitleLabel.getText();
	}

	public void setSubtitle(String subtitle) {
		m_subtitleLabel.setText(subtitle);
	}

	@Override
	protected void themeSet(WindowTheme theme) {
		super.themeSet(theme);

		if (m_theme != null) {
			m_titleLabel.setForeground(m_theme.titleColor);
			m_subtitleLabel.setForeground(m_theme.subtitleColor);
		}
	}
}
