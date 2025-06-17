package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

    private JComboBox<String> comboTipo;
    private JTextField txtCpfCnpj, txtRgIe, txtOrgaoExpedidor, txtEmail, txtCep, txtUfSigla, txtUfNome, txtMunicipio, txtLogradouro, txtNumero, txtComplemento, txtBairro, txtTelefone, txtNome;
    private JCheckBox checkFornecedor;
    private JRadioButton radioAtivo;
    private JRadioButton radioInativo;
    private ButtonGroup grupoSituacao;

    public Cadastro() {
        super("Cadastro de Pessoa");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 550);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800, 500));
        
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitulo = new JLabel("Cadastro de Pessoa");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        lblTitulo.setForeground(new Color(243, 123, 47));
        
        adicionarComponente(mainPanel, lblTitulo, 0, 0, 6, GridBagConstraints.WEST, 0.0, new Insets(0, 0, 30, 0), GridBagConstraints.WEST);

        adicionarComponenteComRotulo(mainPanel, "Tipo", comboTipo = new JComboBox<>(new String[]{"Física", "Jurídica"}), 0, 1, 1, GridBagConstraints.HORIZONTAL, 0.1);
        adicionarComponenteComRotulo(mainPanel, "CPF / CNPJ", txtCpfCnpj = new JTextField(25), 2, 1, 1, GridBagConstraints.HORIZONTAL, 0.4);

        adicionarComponente(mainPanel, criarRotulo("Fornecedor"), 4, 1, 1, GridBagConstraints.NONE, 0.0, new Insets(5, 5, 5, 5), GridBagConstraints.CENTER);
        checkFornecedor = new JCheckBox();
        adicionarComponente(mainPanel, checkFornecedor, 5, 1, 1, GridBagConstraints.NONE, 0.0, new Insets(5, 5, 5, 5), GridBagConstraints.WEST);

        adicionarComponenteComRotulo(mainPanel, "Nome", txtNome = new JTextField(40), 0, 2, 5, GridBagConstraints.HORIZONTAL, 1.0);

        adicionarComponenteComRotulo(mainPanel, "RG / Inscrição Estadual", txtRgIe = new JTextField(20), 0, 3, 1, GridBagConstraints.HORIZONTAL, 0.5);
        adicionarComponenteComRotulo(mainPanel, "Órgão Expedidor", txtOrgaoExpedidor = new JTextField(20), 2, 3, 1, GridBagConstraints.HORIZONTAL, 0.5);

        adicionarComponenteComRotulo(mainPanel, "Email", txtEmail = new JTextField(35), 0, 4, 1, GridBagConstraints.HORIZONTAL, 0.5);
        adicionarComponenteComRotulo(mainPanel, "CEP", txtCep = new JTextField(15), 2, 4, 4, GridBagConstraints.HORIZONTAL, 0.5);

        adicionarComponente(mainPanel, criarRotulo("País"), 0, 5, 1, GridBagConstraints.HORIZONTAL, 0.0, new Insets(5, 5, 5, 5), GridBagConstraints.CENTER);
        JTextField txtPais = criarCampoFixo("BRASIL");
        txtPais.setPreferredSize(new Dimension(200, 30));
        adicionarComponente(mainPanel, txtPais, 1, 5, 1, GridBagConstraints.HORIZONTAL, 0.5, new Insets(5, 5, 5, 5), GridBagConstraints.WEST);
        adicionarComponente(mainPanel, criarRotulo("UF"), 2, 5, 1, GridBagConstraints.HORIZONTAL, 0.0, new Insets(5, 5, 5, 5), GridBagConstraints.CENTER);

        txtUfSigla = new JTextField(2);
        txtUfNome = criarCampoFixo("");
        JPanel ufPanel = new JPanel(new BorderLayout(5, 0));
        ufPanel.add(txtUfSigla, BorderLayout.WEST);
        ufPanel.add(txtUfNome, BorderLayout.CENTER);
        adicionarComponente(mainPanel, ufPanel, 3, 5, 3, GridBagConstraints.HORIZONTAL, 0.5, new Insets(5, 5, 5, 5), GridBagConstraints.WEST);
        
        adicionarComponenteComRotulo(mainPanel, "Município", txtMunicipio = criarCampoFixo(""), 0, 6, 5, GridBagConstraints.HORIZONTAL, 1.0);

        adicionarComponenteComRotulo(mainPanel, "Logradouro", txtLogradouro = new JTextField(40), 0, 7, 5, GridBagConstraints.HORIZONTAL, 1.0);

        adicionarComponenteComRotulo(mainPanel, "Número", txtNumero = new JTextField(10), 0, 8, 1, GridBagConstraints.HORIZONTAL, 0.5);
        adicionarComponenteComRotulo(mainPanel, "Complemento", txtComplemento = new JTextField(25), 2, 8, 1, GridBagConstraints.HORIZONTAL, 0.5);

        adicionarComponenteComRotulo(mainPanel, "Bairro", txtBairro = new JTextField(25), 0, 9, 1, GridBagConstraints.HORIZONTAL, 0.5);
        adicionarComponenteComRotulo(mainPanel, "Telefone", txtTelefone = new JTextField(15), 2, 9, 1, GridBagConstraints.HORIZONTAL, 0.5);
        
        adicionarComponente(mainPanel, criarRotulo("Situação"), 4, 9, 1, GridBagConstraints.NONE, 0.0, new Insets(5, 5, 5, 5), GridBagConstraints.CENTER);
        radioAtivo = new JRadioButton("Ativo");
        radioInativo = new JRadioButton("Inativo");
        grupoSituacao = new ButtonGroup();
        grupoSituacao.add(radioAtivo);
        grupoSituacao.add(radioInativo);
        JPanel radioPanel = new JPanel();
        radioPanel.add(radioAtivo);
        radioPanel.add(radioInativo);
        adicionarComponente(mainPanel, radioPanel, 5, 9, 1, GridBagConstraints.NONE, 0.5, new Insets(5, 5, 5, 5), GridBagConstraints.WEST);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        JButton btnConfirmar = criarBotao("Confirmar", new Color(243, 123, 47), Color.WHITE);
        JButton btnExcluir = criarBotao("Excluir", new Color(243, 123, 47), Color.WHITE);
        JButton btnLimpar = criarBotao("Limpar", Color.LIGHT_GRAY, Color.BLACK);
        
        buttonPanel.add(btnConfirmar);
        buttonPanel.add(btnExcluir);
        buttonPanel.add(btnLimpar);
        
        adicionarComponente(mainPanel, buttonPanel, 0, 10, 6, GridBagConstraints.HORIZONTAL, 1.0, new Insets(30, 0, 0, 0), GridBagConstraints.WEST);

        btnConfirmar.addActionListener(this::confirmarAcao);
        btnLimpar.addActionListener(e -> limparCampos());
        btnExcluir.addActionListener(e -> {
            limparCampos();
            JOptionPane.showMessageDialog(this, "Dados excluídos do formulário.", "Excluído", JOptionPane.INFORMATION_MESSAGE);
        });
        
        setContentPane(mainPanel);
        setVisible(true);
    }
    
    private JLabel criarRotulo(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(200, 30));
        label.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return label;
    }

    private JTextField criarCampoFixo(String texto) {
        JTextField textField = new JTextField(texto);
        textField.setEditable(false);
        textField.setBackground(new Color(230, 230, 230));
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setPreferredSize(new Dimension(200, 30));
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return textField;
    }

    private JButton criarBotao(String texto, Color corFundo, Color corTexto) {
        JButton button = new JButton(texto);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(corFundo);
        button.setForeground(corTexto);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(120, 35));
        button.setBorder(BorderFactory.createEmptyBorder(8, 25, 8, 25));
        return button;
    }

    private void adicionarComponente(JPanel painel, JComponent componente, int gridx, int gridy, int gridwidth, int fill, double weightx, Insets insets, int anchor) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.fill = fill;
        gbc.weightx = weightx;
        gbc.weighty = 0.0;
        gbc.insets = insets;
        gbc.anchor = anchor == GridBagConstraints.NONE ? GridBagConstraints.CENTER : anchor;
        painel.add(componente, gbc);
    }

    private void adicionarComponenteComRotulo(JPanel painel, String textoRotulo, JComponent componente, int gridx, int gridy, int componentGridWidth, int componentFill, double componentWeightX) {
        // Rótulo
        JLabel rotulo = criarRotulo(textoRotulo);
        adicionarComponente(painel, rotulo, gridx, gridy, 1, GridBagConstraints.HORIZONTAL, 0.0, new Insets(5, 5, 5, 5), GridBagConstraints.CENTER);
        
        if (componente instanceof JTextField) {
            ((JTextField) componente).setPreferredSize(new Dimension(200, 30));
            ((JTextField) componente).setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
            ));
        } else if (componente instanceof JComboBox) {
            ((JComboBox<?>) componente).setPreferredSize(new Dimension(200, 30));
        }
        
        adicionarComponente(painel, componente, gridx + 1, gridy, componentGridWidth, GridBagConstraints.HORIZONTAL, 1.0, new Insets(5, 5, 5, 5), GridBagConstraints.WEST);
    }

    private void confirmarAcao(ActionEvent e) {
        String tipo = (String) comboTipo.getSelectedItem();
        String cpfCnpj = txtCpfCnpj.getText();
        boolean isFornecedor = checkFornecedor.isSelected();
        String nome = txtNome.getText();
        String rgIe = txtRgIe.getText();
        String orgaoExpedidor = txtOrgaoExpedidor.getText();
        String email = txtEmail.getText();
        String cep = txtCep.getText();
        String ufSigla = txtUfSigla.getText();
        String ufNome = txtUfNome.getText();
        String municipio = txtMunicipio.getText();
        String logradouro = txtLogradouro.getText();
        String numero = txtNumero.getText();
        String complemento = txtComplemento.getText();
        String bairro = txtBairro.getText();
        String telefone = txtTelefone.getText();

        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Confirmação de Dados:\n");
        mensagem.append("Tipo: ").append(tipo).append("\n");
        mensagem.append("CPF/CNPJ: ").append(cpfCnpj).append("\n");
        mensagem.append("Fornecedor: ").append(isFornecedor ? "Sim" : "Não").append("\n");
        mensagem.append("Nome: ").append(nome).append("\n");
        mensagem.append("RG/Inscrição Estadual: ").append(rgIe).append("\n");
        mensagem.append("Órgão Expedidor: ").append(orgaoExpedidor).append("\n");
        mensagem.append("Email: ").append(email).append("\n");
        mensagem.append("CEP: ").append(cep).append("\n");
        mensagem.append("UF (Sigla): ").append(ufSigla).append("\n");
        mensagem.append("UF (Nome): ").append(ufNome).append("\n");
        mensagem.append("Município: ").append(municipio).append("\n");
        mensagem.append("Logradouro: ").append(logradouro).append("\n");
        mensagem.append("Número: ").append(numero).append("\n");
        mensagem.append("Complemento: ").append(complemento).append("\n");
        mensagem.append("Bairro: ").append(bairro).append("\n");
        mensagem.append("Telefone: ").append(telefone).append("\n");

        String situacao = "Não definido";
        if (radioAtivo.isSelected()) {
            situacao = "Ativo";
        } else if (radioInativo.isSelected()) {
            situacao = "Inativo";
        }
        mensagem.append("Situação: ").append(situacao).append("\n");

        JOptionPane.showMessageDialog(this, mensagem.toString(), "Dados Confirmados", JOptionPane.INFORMATION_MESSAGE);
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCpfCnpj.setText("");
        checkFornecedor.setSelected(false);
        txtRgIe.setText("");
        txtOrgaoExpedidor.setText("");
        txtEmail.setText("");
        txtCep.setText("");
        txtUfSigla.setText("");
        txtUfNome.setText("");
        txtMunicipio.setText("");
        txtLogradouro.setText("");
        txtNumero.setText("");
        txtComplemento.setText("");
        txtBairro.setText("");
        txtTelefone.setText("");
        grupoSituacao.clearSelection();
    }
}