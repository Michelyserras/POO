/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quebracabeca;

import quebracabeca.Model.Peca;
import java.util.List;

public interface ITabuleiro {
   void encaixarPeca(Peca peca);
   void proximaPeca(List<Peca> pecas);
}
