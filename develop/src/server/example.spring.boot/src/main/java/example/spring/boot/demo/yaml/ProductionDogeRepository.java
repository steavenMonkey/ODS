package example.spring.boot.demo.yaml;

public class ProductionDogeRepository implements DogeRepository{

	@Override
	public String getData() {
		StringBuffer doge = new StringBuffer();
        doge.append("░░░░░░░░░▄░░░░░░░░░░░░░░▄").append("\n");
        doge.append("░░░░░░░░▌▒█░░░░░░░░░░░▄▀▒▌").append("\n");
        doge.append("░░░░░░░░▌▒▒█░░░░░░░░▄▀▒▒▒▐").append("\n");
        doge.append("░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐").append("\n");
        doge.append("░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐").append("\n");
        doge.append("░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌").append("\n");
        doge.append("░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒▌").append("\n");
        doge.append("░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐").append("\n");
        doge.append("░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄▌").append("\n");
        doge.append("░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▌").append("\n");
        doge.append("▌▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒▐").append("\n");
        doge.append("▐▒▒▐▀▐▀▒░▄▄▒▄▒▒▒▒▒▒░▒░▒░▒▒▒▒▌").append("\n");
        doge.append("▐▒▒▒▀▀▄▄▒▒▒▄▒▒▒▒▒▒▒▒░▒░▒░▒▒▐").append("\n");
        doge.append("░▌▒▒▒▒▒▒▀▀▀▒▒▒▒▒▒░▒░▒░▒░▒▒▒▌").append("\n");
        doge.append("░▐▒▒▒▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▒▄▒▒▐").append("\n");
        doge.append("░░▀▄▒▒▒▒▒▒▒▒▒▒▒░▒░▒░▒▄▒▒▒▒▌").append("\n");
        doge.append("░░░░▀▄▒▒▒▒▒▒▒▒▒▒▄▄▄▀▒▒▒▒▄▀").append("\n");
        doge.append("░░░░░░▀▄▄▄▄▄▄▀▀▀▒▒▒▒▒▄▄▀").append("\n");
        doge.append("░░░░░░░░░▒▒▒▒▒▒▒▒▒▒▀▀");
        return doge.toString();
	}

}
