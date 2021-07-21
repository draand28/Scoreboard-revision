/*    */ package rien.bijl.Scoreboard.r.Board.Animations;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class Row
/*    */ {
/*    */   private List<String> lines;
/*    */   private int interval;
/*  9 */   private int count = 0;
/* 10 */   private int current = 1;
/*    */   
/*    */   private boolean is_static = false;
/*    */   
/*    */   private String line;
/*    */   
/*    */   public Row(List<String> lines, int interval) {
/* 17 */     this.lines = lines;
/* 18 */     this.interval = interval;
/*    */     
/* 20 */     if (lines.size() == 1) {
/* 21 */       this.is_static = true;
/*    */     } else {
/* 23 */       for (String line : lines) {
/* 24 */         if (line.contains("%")) {
/* 25 */           this.is_static = false;
/*    */           
/*    */           break;
/*    */         } 
/*    */       } 
/*    */     } 
/* 31 */     if (lines.size() < 1) {
/* 32 */       this.line = "";
/*    */     } else {
/* 34 */       this.line = lines.get(0);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String getLine() {
/* 40 */     return this.line;
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {
/* 45 */     if (this.is_static) {
/*    */       return;
/*    */     }
/*    */     
/* 49 */     if (this.count >= this.interval) {
/* 50 */       this.count = 0;
/* 51 */       this.current++;
/*    */       
/* 53 */       if (this.current >= this.lines.size()) {
/* 54 */         this.current = 0;
/*    */       }
/*    */       
/* 57 */       this.line = this.lines.get(this.current);
/*    */     } else {
/*    */       
/* 60 */       this.count++;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Downloads\Scoreboard-revision (1).jar!\rien\bijl\Scoreboard\r\Board\Animations\Row.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */