# DispenserMail <img align="center" alt="Gut-Js" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-plain.svg"><img align="center" alt="Gut-Android" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/androidstudio/androidstudio-original.svg">
Esta aplicação funciona da seguinte maneira, o usuário ao compilar, digita o destinatário, assunto e a mensagem, ao clicar em enviar, será redirecionado ao app de e-mail nativo do seu aparelho, e assim a mensagem a ser enviada já estará toda definida assim sendo preciso somente enviar.
#
📱 Inteface: você deve criar 3 edittext ou inputtext, um botão e uma logo (opcional).
#
codigo fonte: 

    EditText editdestino, editassunto,editmensagem;
    Button btenviar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editdestino = findViewById(R.id.editdestino);
        editassunto = findViewById(R.id.editassunto);
        editmensagem = findViewById(R.id.editmensagem);

        btenviar = findViewById(R.id.btenviar);


        btenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviar_email();

            }

            private void enviar_email(){

                String destino = editdestino.getText().toString();
                String assunto = editassunto.getText().toString();
                String mensagem = editmensagem.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ destino });
                intent.putExtra(Intent.EXTRA_SUBJECT, assunto);
                intent.putExtra(Intent.EXTRA_TEXT, mensagem);

                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,""));

                Toast.makeText(MainActivity.this,"entrei",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
